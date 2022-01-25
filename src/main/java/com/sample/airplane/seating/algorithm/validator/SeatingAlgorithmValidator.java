package com.sample.airplane.seating.algorithm.validator;

import com.sample.airplane.seating.algorithm.exception.SeatingAlgorithmErrors;
import com.sample.airplane.seating.algorithm.exception.SeatingAlgorithmException;

public class SeatingAlgorithmValidator {

    public static void validateSeatAndPassengerCount(int totalPassenger, int totalSeats)
            throws SeatingAlgorithmException {
        if (totalSeats < totalPassenger) {
            System.out.printf("Passenger count is exceeds the given seat layout by %s", (totalPassenger - totalSeats));
            throw new SeatingAlgorithmException(SeatingAlgorithmErrors.PASSENGER_COUNT_EXCEEDS.getError());
        }
    }

    public static void validatePassengerCount(int totalPassenger) throws SeatingAlgorithmException {
        if (totalPassenger <= 0) {
            throw new SeatingAlgorithmException(SeatingAlgorithmErrors.ENTER_VALID_PASSENGER_COUNT.getError());
        }
    }

    public static void validateSeatConfig(Integer[][] seatConfig) throws SeatingAlgorithmException {
        if (seatConfig.length == 0) {
            throw new SeatingAlgorithmException(SeatingAlgorithmErrors.ENTER_VALID_SEAT_LAYOUT_CONFIG.getError());
        }
    }
}
