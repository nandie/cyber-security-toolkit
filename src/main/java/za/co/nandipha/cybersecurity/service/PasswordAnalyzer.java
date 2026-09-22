package za.co.nandipha.cybersecurity.service;

import java.util.Set;

/**
 * Scores password strength based on length, character variety, and whether
 * the password appears on a denylist of commonly breached weak passwords.
 */
public class PasswordAnalyzer {

    private static final Set<String> COMMON_WEAK_PASSWORDS = Set.of(
            "password", "password1", "password1!", "123456", "12345678",
            "qwerty", "qwerty123", "letmein", "welcome", "admin",
            "iloveyou", "monkey", "dragon", "football", "baseball",
            "abc123", "111111", "123123", "sunshine", "master"
    );

    /**
     * Scores a password's strength on a scale of 0 to 5.
     *
     * <p>Passwords matching a known common/weak password (checked case-insensitively)
     * are capped at a score of 1, regardless of character variety — a password like
     * "Password1!" may look varied, but its presence on breach lists makes it
     * fundamentally weak. Otherwise, one point is awarded for each of: length of at
     * least 8 characters, an uppercase letter, a lowercase letter, a digit, and a
     * symbol from {@code !@#$%^&*()}.</p>
     *
     * @param password the password to analyze; null or shorter than 4 characters scores 0
     * @return a strength score from 0 (weakest) to 5 (strongest)
     */
    public int checkStrength(String password) {

        if (password == null || password.length() < 4) {
            return 0;
        }

        if (COMMON_WEAK_PASSWORDS.contains(password.toLowerCase())) {
            return 1;
        }

        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*()].*")) score++;

        return score;
    }
}