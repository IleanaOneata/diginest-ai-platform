package com.diginest.aiagents.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for EmailService.escapeHtml() — the output-layer XSS protection.
 *
 * After I2 fix, this is the ONLY place HTML escaping happens.
 * It must correctly handle all 5 HTML special characters.
 */
class EscapeHtmlTest {

    private String callEscapeHtml(String input) throws Exception {
        EmailService service = new EmailService(null, null);
        Method escapeHtml = EmailService.class.getDeclaredMethod("escapeHtml", String.class);
        escapeHtml.setAccessible(true);
        return (String) escapeHtml.invoke(service, input);
    }

    @Test
    @DisplayName("escapeHtml: null returns empty string")
    void escapeHtml_null_returnsEmpty() throws Exception {
        assertEquals("", callEscapeHtml(null));
    }

    @Test
    @DisplayName("escapeHtml: normal text unchanged")
    void escapeHtml_normalText_unchanged() throws Exception {
        assertEquals("Hello World", callEscapeHtml("Hello World"));
    }

    @Test
    @DisplayName("escapeHtml: ampersand encoded first (no double-encoding)")
    void escapeHtml_ampersandFirst() throws Exception {
        String result = callEscapeHtml("<b>Tom & Jerry</b>");
        assertEquals("&lt;b&gt;Tom &amp; Jerry&lt;/b&gt;", result);
        assertFalse(result.contains("&amp;lt;"), "Double-encoding detected");
    }

    @Test
    @DisplayName("escapeHtml: all 5 HTML special chars escaped")
    void escapeHtml_allSpecialChars() throws Exception {
        String result = callEscapeHtml("a&b<c>d\"e'f");
        assertEquals("a&amp;b&lt;c&gt;d&quot;e&#39;f", result);
    }

    @Test
    @DisplayName("escapeHtml: XSS script tag fully escaped")
    void escapeHtml_xssScript() throws Exception {
        String result = callEscapeHtml("<script>alert('xss')</script>");
        assertEquals("&lt;script&gt;alert(&#39;xss&#39;)&lt;/script&gt;", result);
    }

    @Test
    @DisplayName("escapeHtml: raw data from DB is correctly single-escaped")
    void escapeHtml_rawDbData_singleEscape() throws Exception {
        // Simulates the I2-fixed flow: raw data from DB → escapeHtml → email
        // Previously this would have been double-encoded because DB stored &amp;
        String rawFromDb = "Tom & Jerry's <Company>";
        String result = callEscapeHtml(rawFromDb);
        assertEquals("Tom &amp; Jerry&#39;s &lt;Company&gt;", result);
    }
}
