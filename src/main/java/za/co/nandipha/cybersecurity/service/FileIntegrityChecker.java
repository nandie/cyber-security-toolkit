package za.co.nandipha.cybersecurity.service;

import java.io.FileInputStream;
import java.security.MessageDigest;

public class FileIntegrityChecker {

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

    public static boolean verifyIntegrity(String filePath, String expectedHash)
            throws Exception {

        String currentHash = calculateFileHash(filePath);

        return currentHash.equals(expectedHash);
    }
}
