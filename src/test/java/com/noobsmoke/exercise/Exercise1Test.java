package com.noobsmoke.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

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

    @Test
    void testTopStudents() {
        List<Student> students = List.of(
                new Student("Jackie Chan", 50),
                new Student("Bruce Lee", 95),
                new Student("Ada Lovelace", 88),
                new Student("Alan Turing", 92),
                new Student("Grace Hopper", 85),
                new Student("Katherine Johnson", 90),
                new Student("Linus Torvalds", 78),
                new Student("James Gosling", 83),
                new Student("Margaret Hamilton", 91),
                new Student("Dennis Ritchie", 87)
        );

        List<Student> topStudents = List.of(
                new Student("Ada Lovelace", 88),
                new Student("Dennis Ritchie", 87),
                new Student("Grace Hopper", 85),
                new Student("James Gosling", 83),
                new Student("Linus Torvalds", 78),
                new Student("Jackie Chan", 50)
        );

        List<Student> actualStudent = underTest.getTopStudents(students, 88);
        assertEquals(topStudents, actualStudent);
    }

    @ParameterizedTest
    @MethodSource("getStudentList")
    void testDuplicateNames(List<Student> students, boolean expectedResult) {
        boolean actualResult = underTest.hasDuplicateNames(students);
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> getStudentList() {
        List<Student> studentsWithDuplicates = List.of(
                new Student("Jackie Chan", 50),
                new Student("Bruce Lee", 95),
                new Student("Ada Lovelace", 88),
                new Student("Alan Turing", 92),
                new Student("Grace Hopper", 85),
                new Student("Ada Lovelace", 88),     // duplicate
                new Student("Bruce Lee", 95),        // duplicate
                new Student("Linus Torvalds", 78),
                new Student("James Gosling", 83),
                new Student("Dennis Ritchie", 87)
        );

        List<Student> studentsWithoutDuplicates = List.of(
                new Student("Jackie Chan", 50),
                new Student("Bruce Lee", 95),
                new Student("Ada Lovelace", 88),
                new Student("Alan Turing", 92),
                new Student("Grace Hopper", 85),
                new Student("Linus Torvalds", 78),
                new Student("James Gosling", 83),
                new Student("Dennis Ritchie", 87)
        );

        return Stream.of(
                Arguments.arguments(studentsWithDuplicates, true),
                Arguments.arguments(studentsWithoutDuplicates, false)
        );
    }
}
