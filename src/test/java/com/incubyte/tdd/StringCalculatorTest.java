package com.incubyte.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private final StringCalculator calc = new StringCalculator();

    @Test
    void emptyStringReturnsZero() {
        assertEquals(0, calc.add(""), "Empty string should return 0");
    }

    @Test
    void singleNumberReturnsValue() {
        assertEquals(1, calc.add("1"));
    }

    @Test
    void twoNumbersCommaSeparated() {
        assertEquals(6, calc.add("1,5"));
    }

    @Test
    void multipleNumbersAreSummed() {
        assertEquals(6, calc.add("1,2,3"));
    }

    @Test
    void supportsNewlinesBetweenNumbers() {
        assertEquals(6, calc.add("1\n2,3"));
    }

    @Test
    void supportsCustomDelimiter() {
        assertEquals(3, calc.add("//;\n1;2"), "Custom delimiter ';' should be supported");
    }
}
