package com.noobsmoke;

import com.noobsmoke.tdd.PasswordValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PasswordValidatorTest {

    private final PasswordValidator underTest = new PasswordValidator();
    @Test
    void willFailIfPasswordIsNull() {
        //given
        String password = null;
        assertFalse(underTest.test(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"   ", ""})
    void willFailIfPasswordIsEmpty(String password) {
        assertFalse(underTest.test(password));
    }

    @ParameterizedTest
    @CsvSource({
            "testing1!, true",
            "       testingPassword2@, true",
            "ma3#, false",
            ", false",
            "testingAgain, false"
    })
    void testingPasswordScenarios(String password, boolean expectedResult) {
        assertEquals(expectedResult, underTest.test(password));
    }
}
