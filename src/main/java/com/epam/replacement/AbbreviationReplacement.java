package com.epam.replacement;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AbbreviationReplacement {

    public static final String ABBREVIATIONS = "\\b(Ave\\.?|Ave?|St\\.?|St?|Str\\.?|Str?)\\b";
    private static final Logger logger = Logger.getLogger(AbbreviationReplacement.class.getName());
    private static final Map<String, String> abbreviationsMap = new HashMap<>();

    public static String address =
            """
                    555 Straight Stave Ave, San Francisco, CA 94104
                    444 Ave Maria Stairway St., San Francisco, CA 94104
                    9032 Flave Steep Str, San Francisco, CA 94104""";

    public static void replaceAbbreviationsWithRegex(String address) {
        logger.info("Replacing abbreviations in the input using regex: " + address);

        String replacement;
        Pattern regex = Pattern.compile(address);
        Matcher matcher = regex.matcher(AbbreviationReplacement.address);
        StringBuilder changedAddress = new StringBuilder();

        while (matcher.find()) {
            String abbreviation = matcher.group();
            replacement = getReplacement(abbreviation);
            logger.info("Replacing " + abbreviation + " with " + replacement);

            matcher.appendReplacement(changedAddress, replacement);
        }
        matcher.appendTail(changedAddress);
        System.out.println(changedAddress);
        logger.info("Result after abbreviation replacement: " + changedAddress);
    }

    public static String getReplacement(String abbreviation) {
        return switch (abbreviation) {
            case "Ave", "Ave." -> "Avenue";
            case "St", "St.", "Str", "Str." -> "Street";
            default -> abbreviation;
        };
    }

    public static void replaceAbbreviationsWithMap(String address) {
        abbreviationsMap.put("Ave", "Avenue");
        abbreviationsMap.put("Ave.", "Avenue");
        abbreviationsMap.put("St", "Street");
        abbreviationsMap.put("St.", "Street");
        abbreviationsMap.put("Str", "Street");
        abbreviationsMap.put("Str.", "Street");

        for (Map.Entry<String, String> entry : abbreviationsMap.entrySet()) {
            address = address.replaceAll(Pattern.quote(entry.getKey()), entry.getValue());
            logger.info("Replacing '" + entry.getKey() + "' with '" + entry.getValue() + "'");
        }
        System.out.println(address);
        logger.info("Result after abbreviation replacement: " + address);
    }

    public static void main(String[] args) {
        replaceAbbreviationsWithRegex(ABBREVIATIONS);
        replaceAbbreviationsWithMap(address);
    }
}


