package com.noobsmoke.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise1Test {

    private Exercise1 underTest;

    @BeforeEach()
    void setUp() {
        underTest = new Exercise1();
    }

    @ParameterizedTest
    @CsvSource({
            "95, A",
            "82, B",
            "77, C",
            "69, D",
            "50, E",
            "42, F"
    })
    void testGetGrade(int score, String expectedGrade) {
        String actualGrade = underTest.getGrade(score);
        assertEquals(expectedGrade, actualGrade);
    }

    @ParameterizedTest
    @CsvSource({
            "Omoruyi, 4",
            "Osaretin, 4",
            "Victoria, 4",
            "Adedayo, 4",
            "Sammisola, 4",
            "Boye, 2"
    })
    void testCountVowels(String name, int expectedVowel) {
        int actualVowels = underTest.countVowels(name);
        assertEquals(expectedVowel, actualVowels);
    }
}
