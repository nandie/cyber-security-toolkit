package za.co.nandipha.cybersecurity.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {

    public String generateSHA256(String text) {
        return generateHash(text, "SHA-256");
    }

    /**
     * Generates an MD5 hash of the given text.
     *
     * <p><b>Not recommended for security-sensitive use.</b> MD5 is cryptographically
     * broken — practical collision attacks exist, meaning two different inputs can be
     * deliberately crafted to produce the same hash. This method is included only for
     * legacy compatibility or educational comparison against {@link #generateSHA256(String)}.
     * Use SHA-256 for anything involving integrity checks, password handling, or any
     * other security-relevant purpose.</p>
     *
     * @param text the text to hash
     * @return the MD5 hash as a lowercase hex string
     */
    public String generateMD5(String text) {
        return generateHash(text, "MD5");
    }

    private String generateHash(String text, String algorithm) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byte[] hashBytes = messageDigest.digest(text.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing algorithm not found.", e);
        }
    }
}