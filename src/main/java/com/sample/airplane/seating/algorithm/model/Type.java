package com.sample.airplane.seating.algorithm.model;

public enum Type {
    AISLE("A"),
    WINDOW("W"),
    MIDDLE("M");

    private final String code;

    Type(String code) {
        this.code =  code;
    }

    public String getCode() {
        return code;
    }
}
