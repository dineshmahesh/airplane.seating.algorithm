package com.sample.airplane.seating.algorithm.model;

import java.util.List;

public class Layout {

    private List<Section> sections;
    private List<Seat> seats;

    public Layout(List<Section> sections, List<Seat> seats) {
        this.sections = sections;
        this.seats = seats;
    }

    public List<Section> getSections() {
        return sections;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
