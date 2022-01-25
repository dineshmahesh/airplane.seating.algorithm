package com.sample.airplane.seating.algorithm.factory;

import com.sample.airplane.seating.algorithm.builder.LayoutBuilder;
import com.sample.airplane.seating.algorithm.model.Layout;
import com.sample.airplane.seating.algorithm.util.SeatAllocationUtil;

public class AirplaneSeatingAlgorithm implements SeatingAlgorithm {
    @Override
    public void allocateSeat(Integer[][] seatConfig, int totalPassenger) {
        // Create layout and seats
        Layout layout = new LayoutBuilder(seatConfig).build();
        SeatAllocationUtil seatAllocationUtil = new SeatAllocationUtil(layout, totalPassenger);

        // Assign passengers to seats
        seatAllocationUtil.seatPassengers();

        //Print layout with Passenger number and Seat type
        printLayout(layout);
    }
}
