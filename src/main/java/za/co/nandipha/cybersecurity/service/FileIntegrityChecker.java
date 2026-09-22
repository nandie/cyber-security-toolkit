package za.co.nandipha.cybersecurity.service;

import java.io.FileInputStream;
import java.security.MessageDigest;

/**
 * Provides file integrity verification using SHA-256 cryptographic hashing.
 * A file's hash acts as a unique fingerprint — if even a single byte of the
 * file changes, the resulting hash changes completely, making this useful
 * for detecting tampering or corruption.
 */
public class FileIntegrityChecker {

    /**
     * Calculates the SHA-256 hash of a file's contents.
     *
     * @param filePath path to the file to hash
     * @return the SHA-256 hash of the file, as a lowercase hex string
     * @throws Exception if the file cannot be found or read
     */
    public static String calculateFileHash(String filePath) throws Exception {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        FileInputStream inputStream = new FileInputStream(filePath);

        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            digest.update(buffer, 0, bytesRead);
        }

        inputStream.close();

        byte[] hashBytes = digest.digest();

        StringBuilder hexString = new StringBuilder();

        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }

        return hexString.toString();
    }

    /**
     * Verifies that a file's current hash matches a previously known, trusted hash.
     * Used to confirm a file hasn't been modified or corrupted since the expected
     * hash was recorded.
     *
     * @param filePath path to the file to verify
     * @param expectedHash the trusted SHA-256 hash to compare against
     * @return true if the file's current hash matches the expected hash, false otherwise
     * @throws Exception if the file cannot be found or read
     */
    public static boolean verifyIntegrity(String filePath, String expectedHash)
            throws Exception {

        String currentHash = calculateFileHash(filePath);

        return currentHash.equals(expectedHash);
    }
}