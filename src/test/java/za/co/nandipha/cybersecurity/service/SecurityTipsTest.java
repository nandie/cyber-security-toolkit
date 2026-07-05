package za.co.nandipha.cybersecurity.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityTipsTest {

    @Test
    void shouldReturnPasswordTip() {
        String tip = SecurityTips.getTip("password");

        assertTrue(tip.toLowerCase().contains("password"));
    }

    @Test
    void shouldReturnPhishingTip() {
        String tip = SecurityTips.getTip("phishing");

        assertTrue(tip.toLowerCase().contains("phishing"));
    }

    @Test
    void shouldReturnWifiTip() {
        String tip = SecurityTips.getTip("wifi");

        assertTrue(tip.toLowerCase().contains("wifi"));
    }

    @Test
    void shouldReturnUpdateTip() {
        String tip = SecurityTips.getTip("updates");

        assertTrue(tip.toLowerCase().contains("update"));
    }

    @Test
    void shouldReturnDefaultTipForUnknownTopic() {
        String tip = SecurityTips.getTip("anything");

        assertEquals(
                "Stay alert and always follow cybersecurity best practices.",
                tip
        );
    }
}