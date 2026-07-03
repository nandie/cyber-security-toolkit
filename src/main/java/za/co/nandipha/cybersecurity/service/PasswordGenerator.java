package za.co.nandipha.cybersecurity.service;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+";

    private static final String ALL =
            UPPER + LOWER + NUMBERS + SYMBOLS;

    private final SecureRandom random = new SecureRandom();

    public String generatePassword(int length) {

        if (length < 8) {
            throw new IllegalArgumentException(
                    "Password length must be at least 8 characters.");
        }

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALL.length());
            password.append(ALL.charAt(index));
        }

        return password.toString();
    }
}
