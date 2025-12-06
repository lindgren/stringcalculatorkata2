package uk.co.lindgrens;

/**
 * Performs arithmetic operations on numbers
 */
public class Calculator {

    public int sum(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}

