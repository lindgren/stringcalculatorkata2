package uk.co.lindgrens;

import java.util.ArrayList;
import java.util.List;

/**
 * Extracts and validates numbers from delimited string input
 */
public class NumberExtractor {

    public int[] extractNumbers(String numbersPart, String[] delimiters) {
        String normalizedInput = normalizeNewlines(numbersPart, delimiters[0]);
        String delimiterPattern = buildDelimiterPattern(delimiters);
        String[] numberStrings = normalizedInput.split(delimiterPattern);

        List<Integer> validNumbers = new ArrayList<>();
        NegativeNumberHandler negativeHandler = new NegativeNumberHandler();

        for (String numberString : numberStrings) {
            if (!numberString.trim().isEmpty()) {
                int number = Integer.parseInt(numberString.trim());
                negativeHandler.checkNegative(number);
                if (number <= 1000) {
                    validNumbers.add(number);
                }
            }
        }

        negativeHandler.throwIfNegativesFound();
        return validNumbers.stream().mapToInt(Integer::intValue).toArray();
    }

    private String normalizeNewlines(String input, String firstDelimiter) {
        return input.replace("\n", firstDelimiter);
    }

    private String buildDelimiterPattern(String[] delimiters) {
        StringBuilder pattern = new StringBuilder("[");
        for (int i = 0; i < delimiters.length; i++) {
            if (i > 0) {
                pattern.append("|");
            }
            pattern.append(java.util.regex.Pattern.quote(delimiters[i]));
        }
        pattern.append("]");
        return pattern.toString();
    }
}

