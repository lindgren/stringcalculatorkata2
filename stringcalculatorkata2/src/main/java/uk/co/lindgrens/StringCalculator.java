package uk.co.lindgrens;

/**
 * String Calculator - adds numbers from a string input
 */
public class StringCalculator {

    private final DelimiterParser delimiterParser;
    private final NumberExtractor numberExtractor;
    private final Calculator calculator;

    public StringCalculator() {
        this.delimiterParser = new DelimiterParser();
        this.numberExtractor = new NumberExtractor();
        this.calculator = new Calculator();
    }

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] delimiters = delimiterParser.parseDelimiters(numbers);
        String numbersPart = delimiterParser.extractNumbersPart(numbers);

        int[] numberArray = numberExtractor.extractNumbers(numbersPart, delimiters);

        return calculator.sum(numberArray);
    }
}

