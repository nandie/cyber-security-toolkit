package za.co.nandipha.cybersecurity.service;

public class PasswordAnalyzer {

    public int checkStrength(String password) {

        if (password == null || password.length() < 4) {
            return 0;
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