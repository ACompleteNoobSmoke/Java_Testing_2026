package com.noobsmoke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculatorTest {

    private final Calculator underTest = new Calculator();

    /* During test the flow is the following
        * 1. Setup
        * 2. Invocation
        * 3. Assertion
    * */


    @Test
    void firstAddTest() {
        int a = 2, b = 3;
        int addResult = underTest.add(a, b);
        assertEquals(a + b, addResult);
    }

    @Test
    void firstAddTestIncorrect() {
        int a = 2, b = 3;
        int result = underTest.add(a, b);
        assertNotEquals(6, result);
    }

    @Test
    void secondAddTestCorrect() {
        int[] nums = {1, 2, 3, 4, 5};
        int result = underTest.add(nums);
        assertEquals(15, result);
    }

    @Test
    void secondAddTestAcceptZero() {
        assertEquals(0, underTest.add(0));
    }

    @Test
    void secondAddTestAcceptMultipleValue() {
        assertEquals(3, underTest.add(1, 1, 1));
    }

    @Test
    void addGenericTest() {
        var result = underTest.addGeneric(3, 3);
        assertEquals(6, result);
    }

    @Test
    void addGenericTestAssert() {
        var result = underTest.addGeneric(4, 4);
        assertThat(result).isEqualTo(8);
    }

}
