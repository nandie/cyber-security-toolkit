package za.co.nandipha.cybersecurity.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordAnalyzerTest {

    @Test
    void shouldReturnHigherScoreForStrongPassword() {
        PasswordAnalyzer analyzer = new PasswordAnalyzer();

        int result = analyzer.checkStrength("Abc123!@");

        assertTrue(result >= 4);
    }

    @Test
    void shouldReturnLowScoreForWeakPassword() {
        PasswordAnalyzer analyzer = new PasswordAnalyzer();

        int result = analyzer.checkStrength("123");

        assertTrue(result <= 2);
    }
}