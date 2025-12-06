package uk.co.lindgrens;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for String Calculator Kata
 */
public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    public void shouldReturnZeroForEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void shouldReturnNumberForSingleNumber() {
        assertEquals(1, calculator.add("1"));
        assertEquals(5, calculator.add("5"));
    }

    @Test
    public void shouldReturnSumForTwoNumbers() {
        assertEquals(3, calculator.add("1,2"));
        assertEquals(10, calculator.add("5,5"));
    }

    @Test
    public void shouldHandleMultipleNumbers() {
        assertEquals(6, calculator.add("1,2,3"));
        assertEquals(15, calculator.add("1,2,3,4,5"));
    }

    @Test
    public void shouldHandleNewlinesAsSeparators() {
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(10, calculator.add("1\n2\n3\n4"));
    }

    @Test
    public void shouldSupportCustomDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(6, calculator.add("//|\n1|2|3"));
    }

    @Test
    public void shouldThrowExceptionForNegativeNumbers() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("-1,2");
        });
        assertEquals("Negatives not allowed: -1", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionForMultipleNegativeNumbers() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("-1,-2,3");
        });
        assertEquals("Negatives not allowed: -1,-2", exception.getMessage());
    }

    @Test
    public void shouldIgnoreNumbersLargerThan1000() {
        assertEquals(2, calculator.add("2,1001"));
        assertEquals(1005, calculator.add("2,1000,3"));
    }

    @Test
    public void shouldHandleLongCustomDelimiter() {
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void shouldHandleMultipleCustomDelimiters() {
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void shouldHandleMultipleLongCustomDelimiters() {
        assertEquals(6, calculator.add("//[***][%%%]\n1***2%%%3"));
    }
}
