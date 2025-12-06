package uk.co.lindgrens;

/**
 * Handles validation and collection of negative numbers
 */
public class NegativeNumberHandler {

    private final StringBuilder negatives;

    public NegativeNumberHandler() {
        this.negatives = new StringBuilder();
    }

    public void checkNegative(int number) {
        if (number < 0) {
            appendNegative(number);
        }
    }

    private void appendNegative(int number) {
        if (negatives.length() > 0) {
            negatives.append(",");
        }
        negatives.append(number);
    }

    public void throwIfNegativesFound() {
        if (negatives.length() > 0) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives.toString());
        }
    }
}

