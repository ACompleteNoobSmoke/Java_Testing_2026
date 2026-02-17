package com.noobsmoke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculatorTest {

    Calculator calculator;
    @BeforeEach
    public void initiate() {
        this.calculator = new Calculator();
    }


    @Test
    void firstAddTest() {
        int a = 2, b = 3;
        int addResult = calculator.add(a, b);
        assertEquals(a + b, addResult);
    }

    @Test
    void firstAddTestIncorrect() {
        int a = 2, b = 3;
        int result = calculator.add(a, b);
        assertNotEquals(6, result);
    }
}
