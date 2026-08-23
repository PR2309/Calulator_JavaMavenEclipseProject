package com.jfs.training;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
        "2,3,+,5.0",
        "5,2,-,3.0",
        "4,3,*,12.0",
        "10,2,/,5.0",
        "2,4,^,16.0",
        "0,5,*,0.0",
        "-2,3,^,-8.0"
    })
    void testValidOperations(double a, double b, char op, double expected) {
        assertEquals(expected, Calculator.cal(a, b, op), 0.0001);
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.cal(5, 0, '/'));
    }

    @Test
    void testInvalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.cal(2, 3, '%'));
    }
}