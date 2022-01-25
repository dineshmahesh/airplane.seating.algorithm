package com.sample.airplane.seating.algorithm.exception;

public class SeatingAlgorithmException extends RuntimeException {
    private SeatingAlgorithmError error;

    public SeatingAlgorithmException(SeatingAlgorithmError error) {
        super(error.getMessage());
        this.error = error;
    }
}
