package com.sample.airplane.seating.algorithm.util;

import com.sample.airplane.seating.algorithm.model.Layout;
import com.sample.airplane.seating.algorithm.model.Seat;
import com.sample.airplane.seating.algorithm.model.Section;
import com.sample.airplane.seating.algorithm.model.Type;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SeatAllocationUtil {
    private Layout layout;
    private int passenger;
    public static Queue<Integer> passengersQueue = new LinkedList<>();

    public SeatAllocationUtil(Layout layout, int passenger) {
        this.layout = layout;
        this.passenger =  passenger;
        passengersQueue = constructPassengersQueue();
    }

    public void seatPassengers() {
        int maxRowCount = layout.getSections().stream().max(Comparator.comparingInt(Section::getRowCount))
                                                        .get().getRowCount();
        List<Seat> seats = layout.getSeats();

        // Assign Aisle Seats
        setSeatToPassenger(maxRowCount, seats, Type.AISLE);

        // Assign Window Seats
        setSeatToPassenger(maxRowCount, seats, Type.WINDOW);

        // Assign Middle Seats
        setSeatToPassenger(maxRowCount, seats, Type.MIDDLE);
    }

    private void setSeatToPassenger(int maxRowCount, List<Seat> seats, Type type) {
        IntStream.rangeClosed(1, maxRowCount).forEach(row -> {
            seats.forEach(seat -> {
                if (!passengersQueue.isEmpty() && seat.isAvailable() && seat.getRow() == row &&
                        seat.getType().equals(type)) {
                    seat.setPassengerID(passengersQueue.remove());
                }
            });
        });
    }

    private Queue<Integer> constructPassengersQueue() {
        return IntStream.rangeClosed(1, passenger).boxed().collect(Collectors.toCollection(LinkedList::new));
    }
}
