package com.noobsmoke.exercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class ShippingCostCalculatorTest {

    private final ShippingCostCalculator underTest = new ShippingCostCalculator();

    @Test
    void shouldChargeFiveEurosForSmallPackage() {
        assertThat(underTest.calculate(.5, "Local", false)).isEqualTo(5.0);
    }

    @Test
    void shouldChargeTenEurosForLocalStandardShipping() {
        assertThat(underTest.calculate(2.0, "Local", false)).isEqualTo(10.00);
    }

    @Test
    void shouldChargeTwentyEurosForInternationalShipping() {
        assertThat(underTest.calculate(2.0, "International", false)).isEqualTo(20.00);
    }

    @Test
    void shouldAddExpressFee() {
        assertThat(underTest.calculate(.5, "Local", true)).isEqualTo(20.00);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 100.00})
    void shouldThrowOutOfRangeError(double weightKG) {
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> underTest.calculate(weightKG, "Local", false));
        assertEquals("Incorrect Weight", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "Benin City",
            "OuterSpace"
    })
    void shouldThrowIncorrectRegionException(String region) {
        IllegalStateException exception =
                assertThrows(IllegalStateException.class,
                        () -> underTest.calculate(2.0, region, true));
        assertEquals("Incorrect Region", exception.getMessage());
    }

}
