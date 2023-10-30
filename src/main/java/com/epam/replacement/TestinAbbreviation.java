package com.epam.replacement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestinAbbreviation {
    public static String replaceAbbreviationsWithRegex(String address) {
        Pattern pattern = Pattern.compile("\\b(Ave\\.?|St.\\.?|Str\\.?)\\b");
        Matcher matcher = pattern.matcher(address);
        StringBuilder changedAddress = new StringBuilder();

        while (matcher.find()) {
            String abbreviation = matcher.group(1);
            String replacement;

            switch (abbreviation) {
                case "Ave", "Ave." -> replacement = "Avenue";
                case "St", "St." -> replacement = "Street";
                case "Str", "Str." -> replacement = "Street";
                default -> replacement = abbreviation;
            }

            matcher.appendReplacement(changedAddress, replacement + " ");
        }

        matcher.appendTail(changedAddress);
        return changedAddress.toString();
    }

    public static void main(String[] args) {
        String input = """
                555 Straight Stave Ave, San Francisco, CA 94104
                444 Ave Maria Stairway St., San Francisco, CA 94104
                9032 Flave Steep Str, San Francisco, CA 94104""";

        String result = replaceAbbreviationsWithRegex(input);
        System.out.println(result);
    }
}
