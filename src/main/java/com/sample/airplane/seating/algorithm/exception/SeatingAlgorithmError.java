package com.sample.airplane.seating.algorithm.exception;

import java.io.Serializable;

public class SeatingAlgorithmError implements Serializable {
    private String code;
    private String message;

    public SeatingAlgorithmError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
