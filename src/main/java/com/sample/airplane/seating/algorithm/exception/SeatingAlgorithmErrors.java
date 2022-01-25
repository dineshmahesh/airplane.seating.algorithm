package com.sample.airplane.seating.algorithm.exception;

public enum SeatingAlgorithmErrors {

    ENTER_VALID_CONFIG_FORMAT("enterValidConfigFormat", "Enter valid config format"),
    UNKNOWN_ERROR_OCCURRED("unknownErrorOccurred", "Unknown Error Occurred"),
    PASSENGER_COUNT_EXCEEDS("passengerCountExceedsGivenLayout", "Passenger count exceeds the given seat layout"),
    ENTER_VALID_PASSENGER_COUNT("enterValidPassengerCount", "Enter a valid passenger count"),
    ENTER_VALID_SEAT_LAYOUT_CONFIG("enterValidSeatConfig", "Enter a valid Seat Layout config");

    private final String code;
    private final String message;

    SeatingAlgorithmErrors(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public SeatingAlgorithmError getError() { return new SeatingAlgorithmError(this.code, this.message); }
}
