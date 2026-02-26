package com.noobsmoke.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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

    @ParameterizedTest
    @CsvSource({
            "S2344, true",
            "A324, false",
            "S3423243, false",
            "S1238, true"
    })
    void testValidStudentID(String studentID, boolean expectedResult) {
        assertEquals(expectedResult, underTest.isValidStudentId(studentID));
    }

    @Test
    void testCalculateAverage() {
        List<Integer> scores = List.of(20, 10, 89, 23, 34, 100, 45);
        double expectAVG = 45.857142857142854;

        double actualAVG = underTest.calculateAverage(scores);
        assertEquals(expectAVG, actualAVG);
    }


    @ParameterizedTest
    @CsvSource({
            "Jackie Chan, jchan",
            "Naruto Uzumaki, nuzumaki",
            "Rock Lee, rlee"
    })
    void testGenerateUsername(String fullName, String expectedUsername) {
        String actualUsername = underTest.generateUsername(fullName);
        assertEquals(expectedUsername, actualUsername);
    }
}
