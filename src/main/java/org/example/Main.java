package org.example;

import za.co.nandipha.cybersecurity.service.FileIntegrityChecker;
import za.co.nandipha.cybersecurity.service.HashGenerator;
import za.co.nandipha.cybersecurity.service.PasswordAnalyzer;
import za.co.nandipha.cybersecurity.service.PasswordGenerator;
import za.co.nandipha.cybersecurity.service.SecurityTips;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashGenerator hashGenerator = new HashGenerator();
        PasswordAnalyzer passwordAnalyzer = new PasswordAnalyzer();
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        boolean running = true;

        while (running) {
            printMenu();
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    runFileIntegrityChecker(scanner);
                    break;
                case "2":
                    runHashGenerator(scanner, hashGenerator);
                    break;
                case "3":
                    runPasswordAnalyzer(scanner, passwordAnalyzer);
                    break;
                case "4":
                    runPasswordGenerator(scanner, passwordGenerator);
                    break;
                case "5":
                    runSecurityTips(scanner);
                    break;
                case "6":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number from 1 to 6.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n===== Cyber Security Toolkit =====");
        System.out.println("1. File Integrity Checker");
        System.out.println("2. Hash Generator");
        System.out.println("3. Password Analyzer");
        System.out.println("4. Password Generator");
        System.out.println("5. Security Tips");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    private static void runFileIntegrityChecker(Scanner scanner) {
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine().trim();

        try {
            String hash = FileIntegrityChecker.calculateFileHash(filePath);
            System.out.println("SHA-256 hash: " + hash);

            System.out.print("Do you want to verify against a known hash? (y/n): ");
            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("y")) {
                System.out.print("Enter the expected hash: ");
                String expectedHash = scanner.nextLine().trim();
                boolean isIntact = FileIntegrityChecker.verifyIntegrity(filePath, expectedHash);
                System.out.println("File integrity check: " + (isIntact ? "PASSED - file matches" : "FAILED - file does not match"));
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void runHashGenerator(Scanner scanner, HashGenerator hashGenerator) {
        System.out.print("Enter text to hash: ");
        String text = scanner.nextLine();

        System.out.println("SHA-256: " + hashGenerator.generateSHA256(text));
        System.out.println("MD5 (legacy, not for security use): " + hashGenerator.generateMD5(text));
    }

    private static void runPasswordAnalyzer(Scanner scanner, PasswordAnalyzer passwordAnalyzer) {
        System.out.print("Enter a password to analyze: ");
        String password = scanner.nextLine();

        int score = passwordAnalyzer.checkStrength(password);
        System.out.println("Password strength score: " + score + "/5");
    }

    private static void runPasswordGenerator(Scanner scanner, PasswordGenerator passwordGenerator) {
        System.out.print("Enter desired password length (minimum 8): ");
        String lengthInput = scanner.nextLine().trim();

        try {
            int length = Integer.parseInt(lengthInput);
            String password = passwordGenerator.generatePassword(length);
            System.out.println("Generated password: " + password);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runSecurityTips(Scanner scanner) {
        System.out.print("Enter a topic (password, phishing, wifi, updates): ");
        String topic = scanner.nextLine().trim();

        String tip = SecurityTips.getTip(topic);
        System.out.println("Tip: " + tip);
    }
}
