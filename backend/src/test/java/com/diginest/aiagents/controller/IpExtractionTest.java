package com.diginest.aiagents.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for getClientIp() in controllers.
 *
 * Critical: Verifies that the RIGHTMOST IP in X-Forwarded-For is used
 * (added by trusted proxy), not the leftmost (spoofable by client).
 * This was a bug (C2 in TECHNICAL-AUDIT.md).
 */
class IpExtractionTest {

    private String callGetClientIp(Object controller, MockHttpServletRequest request) throws Exception {
        Method method = controller.getClass().getDeclaredMethod("getClientIp",
            jakarta.servlet.http.HttpServletRequest.class);
        method.setAccessible(true);
        return (String) method.invoke(controller, request);
    }

    @Test
    @DisplayName("getClientIp: single IP in X-Forwarded-For")
    void singleIp_returnsIt() throws Exception {
        ContactController controller = new ContactController(null, null);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("X-Forwarded-For", "1.2.3.4");

        assertEquals("1.2.3.4", callGetClientIp(controller, request));
    }

    @Test
    @DisplayName("getClientIp: multiple IPs — returns RIGHTMOST (trusted proxy)")
    void multipleIps_returnsRightmost() throws Exception {
        ContactController controller = new ContactController(null, null);
        MockHttpServletRequest request = new MockHttpServletRequest();
        // Client spoofs "fake-ip", real IP added by Railway proxy is last
        request.addHeader("X-Forwarded-For", "fake-client-ip, intermediate-proxy, 5.6.7.8");

        assertEquals("5.6.7.8", callGetClientIp(controller, request));
    }

    @Test
    @DisplayName("getClientIp: no X-Forwarded-For, uses X-Real-IP")
    void noXff_usesXRealIp() throws Exception {
        ContactController controller = new ContactController(null, null);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("X-Real-IP", "10.0.0.1");

        assertEquals("10.0.0.1", callGetClientIp(controller, request));
    }

    @Test
    @DisplayName("getClientIp: no proxy headers, uses remoteAddr")
    void noHeaders_usesRemoteAddr() throws Exception {
        ContactController controller = new ContactController(null, null);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRemoteAddr("192.168.1.1");

        assertEquals("192.168.1.1", callGetClientIp(controller, request));
    }

    @Test
    @DisplayName("getClientIp: trims whitespace from IP")
    void trimsWhitespace() throws Exception {
        ContactController controller = new ContactController(null, null);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("X-Forwarded-For", " 1.2.3.4 , 5.6.7.8 ");

        assertEquals("5.6.7.8", callGetClientIp(controller, request));
    }

    @Test
    @DisplayName("DemoController: same rightmost IP behavior")
    void demoController_sameRightmostBehavior() throws Exception {
        DemoController controller = new DemoController(null, null);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("X-Forwarded-For", "spoofed, real-proxy-ip");

        assertEquals("real-proxy-ip", callGetClientIp(controller, request));
    }
}
