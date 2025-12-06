package uk.co.lindgrens;

/**
 * Parses delimiters from string calculator input
 */
public class DelimiterParser {

    public String[] parseDelimiters(String input) {
        if (!input.startsWith("//")) {
            return new String[]{","};
        }

        int delimiterEndIndex = input.indexOf("\n");
        String delimiterSection = input.substring(2, delimiterEndIndex);

        if (hasMultipleDelimiters(delimiterSection)) {
            return parseMultipleDelimiters(delimiterSection);
        }

        return new String[]{delimiterSection};
    }

    private boolean hasMultipleDelimiters(String delimiterSection) {
        return delimiterSection.startsWith("[") && delimiterSection.contains("]");
    }

    private String[] parseMultipleDelimiters(String delimiterSection) {
        String[] delimiterMatches = delimiterSection.split("\\]\\[");
        String[] delimiters = new String[delimiterMatches.length];
        for (int i = 0; i < delimiterMatches.length; i++) {
            delimiters[i] = delimiterMatches[i].replaceAll("\\[|\\]", "");
        }
        return delimiters;
    }

    public String extractNumbersPart(String input) {
        if (!input.startsWith("//")) {
            return input;
        }

        int delimiterEndIndex = input.indexOf("\n");
        return input.substring(delimiterEndIndex + 1);
    }
}

