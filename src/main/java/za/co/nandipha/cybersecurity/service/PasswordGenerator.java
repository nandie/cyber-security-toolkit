package za.co.nandipha.cybersecurity.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        List<Character> passwordChars = new ArrayList<>();

        // Step 1: guarantee one character from each category
        passwordChars.add(UPPER.charAt(random.nextInt(UPPER.length())));
        passwordChars.add(LOWER.charAt(random.nextInt(LOWER.length())));
        passwordChars.add(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        passwordChars.add(SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));

        // Step 2: fill the rest randomly from the full pool
        for (int i = passwordChars.size(); i < length; i++) {
            passwordChars.add(ALL.charAt(random.nextInt(ALL.length())));
        }

        // Step 3: shuffle so the guaranteed characters aren't always first
        Collections.shuffle(passwordChars, random);

        // Step 4: build the final string
        StringBuilder password = new StringBuilder();
        for (char c : passwordChars) {
            password.append(c);
        }

        return password.toString();
    }
}