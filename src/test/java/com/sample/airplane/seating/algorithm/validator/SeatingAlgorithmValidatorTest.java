package com.sample.airplane.seating.algorithm.validator;

import com.sample.airplane.seating.algorithm.exception.SeatingAlgorithmException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeatingAlgorithmValidatorTest {

    @Test
    void testValidateSeatAndPassengerCount() {
        Exception thrown = Assert.assertThrows(SeatingAlgorithmException.class,
                () -> SeatingAlgorithmValidator.validateSeatAndPassengerCount(30, 25));
        Assert.assertEquals("Passenger count exceeds the given seat layout", thrown.getMessage());
    }

    @Test
    void testValidatePassengerCount() {
        Exception thrown = Assert.assertThrows(SeatingAlgorithmException.class,
                () -> SeatingAlgorithmValidator.validatePassengerCount(0));
        Assert.assertEquals("Enter a valid passenger count", thrown.getMessage());
    }

    @Test
    void testValidateSeatConfig() {
        Exception thrown = Assert.assertThrows(SeatingAlgorithmException.class,
                () -> SeatingAlgorithmValidator.validateSeatConfig(new Integer[][]{}));
        Assert.assertEquals("Enter a valid Seat Layout config", thrown.getMessage());
    }
}
