package uk.co.lindgrens;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for App
 */
public class AppTest {

    @Test
    public void shouldExecuteMainMethodWithoutException() {
        // Test that main method doesn't throw exceptions
        App.main(new String[]{});
    }
}
