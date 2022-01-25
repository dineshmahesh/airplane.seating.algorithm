package com.sample.airplane.seating.algorithm.builder;

import com.sample.airplane.seating.algorithm.model.Layout;
import com.sample.airplane.seating.algorithm.model.Seat;
import com.sample.airplane.seating.algorithm.model.Section;

import java.util.List;

public class LayoutBuilder {

    private Integer[][] layoutConfig;

    public LayoutBuilder(Integer[][] layoutConfig) {
        this.layoutConfig = layoutConfig;
    }

    private SectionBuilder withSection(Integer[][] layoutConfig) {
        return new SectionBuilder(layoutConfig);
    }

    private SeatBuilder withSeat(List<Section> sections) {
        return new SeatBuilder(sections);
    }

    public Layout build() {
        List<Section> sections = withSection(layoutConfig).build();
        List<Seat> seats = withSeat(sections).build();
        return new Layout(sections, seats);
    }
}
