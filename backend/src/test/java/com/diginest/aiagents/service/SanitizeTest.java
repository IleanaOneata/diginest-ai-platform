package com.diginest.aiagents.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the sanitize() method in ContactService and DemoService.
 *
 * Critical: Verifies that & is encoded BEFORE < and > to prevent double-encoding.
 * This was a bug (C3 in TECHNICAL-AUDIT.md) where "&lt;" became "&amp;lt;".
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
    @DisplayName("sanitize: escapes < and > without double-encoding &")
    void sanitize_noDoubleEncoding() throws Exception {
        ContactService service = new ContactService(null, null);
        String result = callSanitize(service, "<script>alert('xss')</script>");

        // Correct: & is encoded FIRST, then < and >
        // "<script>" should become "&lt;script&gt;" NOT "&amp;lt;script&amp;gt;"
        assertEquals("&lt;script&gt;alert(&#x27;xss&#x27;)&lt;/script&gt;", result);
        assertFalse(result.contains("&amp;lt;"), "Double-encoding detected! & was encoded AFTER < replacement");
        assertFalse(result.contains("&amp;gt;"), "Double-encoding detected! & was encoded AFTER > replacement");
    }

    @Test
    @DisplayName("sanitize: ampersand in normal text encoded correctly")
    void sanitize_ampersand_encodedCorrectly() throws Exception {
        ContactService service = new ContactService(null, null);
        assertEquals("Tom &amp; Jerry", callSanitize(service, "Tom & Jerry"));
    }

    @Test
    @DisplayName("sanitize: quotes are escaped")
    void sanitize_quotesEscaped() throws Exception {
        ContactService service = new ContactService(null, null);
        String result = callSanitize(service, "He said \"hello\" and it's fine");
        assertTrue(result.contains("&quot;"), "Double quotes should be escaped");
        assertTrue(result.contains("&#x27;"), "Single quotes should be escaped");
    }

    @Test
    @DisplayName("sanitize: DemoService has same correct ordering")
    void sanitize_demoService_sameOrdering() throws Exception {
        DemoService demoService = new DemoService(null, null);
        String result = callSanitize(demoService, "<b>Bold & Beautiful</b>");
        assertEquals("&lt;b&gt;Bold &amp; Beautiful&lt;/b&gt;", result);
        assertFalse(result.contains("&amp;lt;"), "DemoService: Double-encoding detected!");
    }
}
