package com.sample.airplane.seating.algorithm.model;

import java.util.Objects;

public class Seat {

    private int sectionId;
    private int row;
    private int column;
    private int seatNumber;
    private Integer passengerID;
    private Type type;

    public Seat(int sectionId, int row, int column, int seatNumber, Type type) {
        this.sectionId = sectionId;
        this.row = row;
        this.column = column;
        this.seatNumber = seatNumber;
        this.type = type;
    }

    public int getSectionId() {
        return sectionId;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Integer getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Integer passengerID) {
        this.passengerID = passengerID;
    }

    public boolean isAvailable() {
        return Objects.isNull(getPassengerID());
    }

    public Type getType() {
        return type;
    }
}
