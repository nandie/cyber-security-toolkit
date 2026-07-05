package za.co.nandipha.cybersecurity.service;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileIntegrityCheckerTest {

    @Test
    void shouldGenerateHashForExistingFile() throws Exception {

        Path tempFile = Files.createTempFile("test", ".txt");
        Files.writeString(tempFile, "Hello World");

        String hash = FileIntegrityChecker.calculateFileHash(tempFile.toString());

        assertNotNull(hash);
        assertEquals(64, hash.length());

        Files.deleteIfExists(tempFile);
    }

    @Test
    void shouldVerifyFileIntegrity() throws Exception {

        Path tempFile = Files.createTempFile("test", ".txt");
        Files.writeString(tempFile, "Cyber Security");

        String originalHash =
                FileIntegrityChecker.calculateFileHash(tempFile.toString());

        assertTrue(
                FileIntegrityChecker.verifyIntegrity(
                        tempFile.toString(),
                        originalHash
                )
        );

        Files.deleteIfExists(tempFile);
    }

    @Test
    void shouldDetectModifiedFile() throws Exception {

        Path tempFile = Files.createTempFile("test", ".txt");
        Files.writeString(tempFile, "Original");

        String originalHash =
                FileIntegrityChecker.calculateFileHash(tempFile.toString());

        Files.writeString(tempFile, "Modified");

        assertFalse(
                FileIntegrityChecker.verifyIntegrity(
                        tempFile.toString(),
                        originalHash
                )
        );

        Files.deleteIfExists(tempFile);
    }
}

