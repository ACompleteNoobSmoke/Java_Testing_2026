package com.noobsmoke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @Test
    void secondAddTestCorrect() {
        int[] nums = {1, 2, 3, 4, 5};
        int result = calculator.add(nums);
        assertEquals(15, result);
    }

    @Test
    void secondAddTestAcceptZero() {
        assertEquals(0, calculator.add(0));
    }

    @Test
    void secondAddTestAcceptMultipleValue() {
        assertEquals(3, calculator.add(1, 1, 1));
    }

    @Test
    void addGenericTest() {
        var result = calculator.addGeneric(3, 3);
        assertEquals(6, result);
    }

    @Test
    void addGenericTestAssert() {
        var result = calculator.addGeneric(4, 4);
        assertThat(result).isEqualTo(8);
    }
}
