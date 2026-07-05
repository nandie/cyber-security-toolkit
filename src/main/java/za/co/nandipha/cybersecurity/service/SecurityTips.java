package za.co.nandipha.cybersecurity.service;

public class SecurityTips {

    public static String getTip(String topic) {

        if (topic == null) {
            return "Stay alert and always follow cybersecurity best practices.";
        }

        switch (topic.toLowerCase()) {

            case "password":
                return "Use a strong password, avoid reusing passwords, and enable multi-factor authentication.";

            case "phishing":
                return "Beware of phishing emails and never click suspicious links or attachments.";

            case "wifi":
                return "Avoid using public wifi for sensitive activities unless you use a trusted VPN.";

            case "updates":
                return "Keep your operating system and software updated to protect against security vulnerabilities.";

            default:
                return "Stay alert and always follow cybersecurity best practices.";
        }
    }
}