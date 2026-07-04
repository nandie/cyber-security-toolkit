package za.co.nandipha.cybersecurity.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashGeneratorTest {

    @Test
    void shouldGenerateSHA256Hash() {
        HashGenerator generator = new HashGenerator();

        String hash = generator.generateSHA256("password123");

        assertNotNull(hash);
        assertEquals(64, hash.length());
    }

    @Test
    void shouldGenerateMD5Hash() {
        HashGenerator generator = new HashGenerator();

        String hash = generator.generateMD5("password123");

        assertNotNull(hash);
        assertEquals(32, hash.length());
    }

    @Test
    void shouldGenerateSameHashForSameInput() {
        HashGenerator generator = new HashGenerator();

        String hash1 = generator.generateSHA256("hello");
        String hash2 = generator.generateSHA256("hello");

        assertEquals(hash1, hash2);
    }

    @Test
    void shouldGenerateDifferentHashesForDifferentInputs() {
        HashGenerator generator = new HashGenerator();

        String hash1 = generator.generateSHA256("hello");
        String hash2 = generator.generateSHA256("world");

        assertNotEquals(hash1, hash2);
    }
}
