package com.sample.airplane.seating.algorithm.builder;

import com.sample.airplane.seating.algorithm.model.Seat;
import com.sample.airplane.seating.algorithm.model.Section;
import com.sample.airplane.seating.algorithm.model.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SeatBuilder {
    private List<Section> sections;

    public SeatBuilder(List<Section> sections) {
        this.sections = sections;
    }

    public List<Seat> build() {
        List<Seat> seats = new ArrayList<>();
        AtomicInteger seatNumber = new AtomicInteger(1);
        sections.forEach(section -> {
            IntStream.rangeClosed(1, section.getRowCount()).forEach(row -> {
                IntStream.rangeClosed(1, section.getColCount()).forEach(column -> {
                    seats.add(new Seat(section.getSectionId(), row, column, seatNumber.getAndAdd(1), getSeatType(column, section)));
                });
            });
        });
        return seats;
    }

    private Type getSeatType(int column, Section section) {
        if ((section.getSectionId() == 1 && column == 1) ||
            (section.getSectionId() == sections.size() && column == section.getColCount())) {
            return Type.WINDOW;
        }
        if ((column == 1 && section.getSectionId() != 1) || column == section.getColCount()) {
            return Type.AISLE;
        }
        return Type.MIDDLE;
    }
}
