package com.noobsmoke;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LifeCycleCalculatorTest {

    private Calculator underTest;

    //Lifecycle is usually used to set up a state before the tests
    // Such as like Database

    @BeforeEach
    void setUp() {
        System.out.println("Runs this method before every test");
        System.out.println();
        underTest = new Calculator();
    }

    // After Each is to stop or tear down things after each test
    @AfterEach
    void tearDown() {

    }


    @BeforeAll
    static void beforeAll() {

    }

    @Test
    void canAddTwoNumbers() {
        int number1 = 4;
        int number2 = 5;
        int expectedResult = 9;
        int actual = underTest.add(number1, number2);
        assertEquals(actual, expectedResult);
    }
}
