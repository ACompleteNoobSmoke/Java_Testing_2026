package com.noobsmoke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    private EmailValidator underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmailValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"ofonmwan@gmail.com", "a-aroon@yahoo.com", "goofygoober@chumbucket.com"})
    void canValidateEmail(String email) {
        boolean actualResult = underTest.test(email.trim());
        assertTrue(actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "jackiechan, false",
            "hello@acompletenoobsmoke.io, true"
    })
    void canValidateEmailMultipleScenario(String email, boolean expected) {
        boolean actualResult = underTest.test(email);
        assertEquals(expected, actualResult);
    }

}