package za.co.nandipha.cybersecurity.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest {

    @Test
    void shouldGeneratePasswordOfRequestedLength() {
        PasswordGenerator generator = new PasswordGenerator();

        String password = generator.generatePassword(12);

        assertEquals(12, password.length());
    }

    @Test
    void shouldThrowExceptionForShortPasswordLength() {
        PasswordGenerator generator = new PasswordGenerator();

        assertThrows(IllegalArgumentException.class, () -> {
            generator.generatePassword(5);
        });
    }

    @Test
    void shouldGenerateDifferentPasswords() {
        PasswordGenerator generator = new PasswordGenerator();

        String first = generator.generatePassword(12);
        String second = generator.generatePassword(12);

        assertNotEquals(first, second);
    }
}
