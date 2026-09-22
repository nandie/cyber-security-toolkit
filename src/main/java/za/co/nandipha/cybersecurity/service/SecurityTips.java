package za.co.nandipha.cybersecurity.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides practical cybersecurity advice by topic, covering common areas
 * such as password hygiene, phishing, public wifi use, and software updates.
 */
public class SecurityTips {

    private static final Map<String, String> TIPS = new HashMap<>();

    private static final String DEFAULT_TIP =
            "Stay alert and always follow cybersecurity best practices.";

    static {
        TIPS.put("password", "Use a strong password, avoid reusing passwords, and enable multi-factor authentication.");
        TIPS.put("phishing", "Beware of phishing emails and never click suspicious links or attachments.");
        TIPS.put("wifi", "Avoid using public wifi for sensitive activities unless you use a trusted VPN.");
        TIPS.put("updates", "Keep your operating system and software updated to protect against security vulnerabilities.");
    }

    /**
     * Returns a security tip for the given topic.
     *
     * @param topic the topic to get a tip for (e.g. "password", "phishing", "wifi",
     *              "updates"), matched case-insensitively; may be null
     * @return the tip for the given topic, or a general fallback tip if the topic
     *         is null or not recognized
     */
    public static String getTip(String topic) {

        if (topic == null) {
            return DEFAULT_TIP;
        }

        return TIPS.getOrDefault(topic.toLowerCase(), DEFAULT_TIP);
    }
}