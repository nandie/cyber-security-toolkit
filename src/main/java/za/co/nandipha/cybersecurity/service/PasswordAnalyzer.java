package za.co.nandipha.cybersecurity.service;

import java.util.Set;

public class PasswordAnalyzer {

    private static final Set<String> COMMON_WEAK_PASSWORDS = Set.of(
            "password", "password1", "password1!", "123456", "12345678",
            "qwerty", "qwerty123", "letmein", "welcome", "admin",
            "iloveyou", "monkey", "dragon", "football", "baseball",
            "abc123", "111111", "123123", "sunshine", "master"
    );

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