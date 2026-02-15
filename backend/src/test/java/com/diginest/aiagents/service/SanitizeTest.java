package com.diginest.aiagents.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the sanitize() method in ContactService and DemoService.
 *
 * After I2 audit fix: sanitize() performs ONLY trimming.
 * HTML escaping is done at the output layer (EmailService.escapeHtml()).
 */
class SanitizeTest {

    /**
     * Access private sanitize() method via reflection for testing.
     */
    private String callSanitize(Object service, String input) throws Exception {
        Method sanitize = service.getClass().getDeclaredMethod("sanitize", String.class);
        sanitize.setAccessible(true);
        return (String) sanitize.invoke(service, input);
    }

    @Test
    @DisplayName("sanitize: null input returns null")
    void sanitize_null_returnsNull() throws Exception {
        ContactService service = new ContactService(null, null);
        assertNull(callSanitize(service, null));
    }

    @Test
    @DisplayName("sanitize: normal text unchanged")
    void sanitize_normalText_unchanged() throws Exception {
        ContactService service = new ContactService(null, null);
        assertEquals("Hello World", callSanitize(service, "Hello World"));
    }

    @Test
    @DisplayName("sanitize: trims whitespace")
    void sanitize_trimsWhitespace() throws Exception {
        ContactService service = new ContactService(null, null);
        assertEquals("Hello", callSanitize(service, "  Hello  "));
    }

    @Test
    @DisplayName("sanitize: HTML characters preserved raw (no escaping at input layer)")
    void sanitize_htmlPreserved() throws Exception {
        ContactService service = new ContactService(null, null);
        // After I2 fix: sanitize does NOT HTML-encode.
        // Raw data is stored in DB; escaping happens at output layer.
        assertEquals("<script>alert('xss')</script>",
            callSanitize(service, "<script>alert('xss')</script>"));
    }

    @Test
    @DisplayName("sanitize: ampersand preserved as raw character")
    void sanitize_ampersandPreserved() throws Exception {
        ContactService service = new ContactService(null, null);
        assertEquals("Tom & Jerry", callSanitize(service, "Tom & Jerry"));
    }

    @Test
    @DisplayName("sanitize: quotes preserved as raw characters")
    void sanitize_quotesPreserved() throws Exception {
        ContactService service = new ContactService(null, null);
        String result = callSanitize(service, "He said \"hello\" and it's fine");
        assertTrue(result.contains("\""), "Double quotes should be preserved raw");
        assertTrue(result.contains("'"), "Single quotes should be preserved raw");
    }

    @Test
    @DisplayName("sanitize: DemoService behaves identically (trim only)")
    void sanitize_demoService_identical() throws Exception {
        DemoService demoService = new DemoService(null, null);
        assertEquals("<b>Bold & Beautiful</b>",
            callSanitize(demoService, "<b>Bold & Beautiful</b>"));
    }
}
