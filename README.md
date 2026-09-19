# Cyber Security Toolkit

A Java toolkit of security utilities — built to demonstrate practical, hands-on cybersecurity concepts across cryptographic hashing, data integrity, and authentication security.

## Overview

This project brings together five independent security tools, each modeling a real-world security practice:

| Tool | What it does | Security concept demonstrated |
|---|---|---|
| **FileIntegrityChecker** | Verifies a file hasn't been tampered with | Cryptographic hashing (SHA-256) for integrity verification |
| **HashGenerator** | Generates SHA-256 and MD5 hashes of text | Hash algorithm selection and trade-offs |
| **PasswordAnalyzer** | Scores password strength (0–5) | Authentication policy / password complexity rules |
| **PasswordGenerator** | Generates strong, random passwords | Secure randomness (SecureRandom) and guaranteed character variety |
| **SecurityTips** | Returns security advice by topic | Security awareness / user education |

Together they cover four pillars of practical security: cryptographic hashing, data integrity, authentication strength, and user education.

## Tech Stack

- **Language:** Java 21
- **Build tool:** Maven
- **Testing:** JUnit 5 (Jupiter)

## Getting Started

### Prerequisites
- Java 21 (JDK)
- Maven

### Build and run tests

mvn test

### Run the demo

mvn compile exec:java -Dexec.mainClass="org.example.Main"

## Usage Examples

**Check file integrity:**

String hash = FileIntegrityChecker.calculateFileHash("myfile.txt");
boolean isIntact = FileIntegrityChecker.verifyIntegrity("myfile.txt", knownGoodHash);

**Generate a hash:**

HashGenerator generator = new HashGenerator();
String sha256 = generator.generateSHA256("hello world");

**Analyze password strength:**

PasswordAnalyzer analyzer = new PasswordAnalyzer();
int score = analyzer.checkStrength("MyP@ssw0rd");

**Generate a strong password:**

PasswordGenerator generator = new PasswordGenerator();
String password = generator.generatePassword(12);

**Get a security tip:**

String tip = SecurityTips.getTip("phishing");

## Design Decisions

- **SHA-256 over MD5 for integrity checks.** MD5 is cryptographically broken and unsuitable for security-sensitive use. It's included in HashGenerator only for legacy/educational comparison.
- **SecureRandom over Random in PasswordGenerator.** Random is predictable and unsuitable for anything security-related; SecureRandom uses a cryptographically strong random number source.
- **Guaranteed character-class coverage in PasswordGenerator.** Forces one character from each category (upper, lower, number, symbol) before filling the rest randomly, then shuffles the result.

See the project Wiki for full details on architecture, design decisions, setup, and testing.

## Testing

17 passing tests across all five service classes, run via JUnit 5.

## Author

**Nandipha** — built as a cybersecurity portfolio and competition project.