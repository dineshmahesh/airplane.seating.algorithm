package com.sample.airplane.seating.algorithm.util;

import com.sample.airplane.seating.algorithm.model.Layout;
import com.sample.airplane.seating.algorithm.model.Seat;
import com.sample.airplane.seating.algorithm.model.Section;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LayoutPrintUtil {

    private Layout layout;

    public LayoutPrintUtil(Layout layout) {
        this.layout = layout;
    }

    public void printLayout() {

        List<Section> sections = layout.getSections();
        List<Seat> seats = layout.getSeats();
        int maxRowCount = sections.stream().max(Comparator.comparingInt(Section::getRowCount))
                                           .get().getRowCount();

        IntStream.rangeClosed(1, maxRowCount).forEach(row -> {
            sections.forEach(section -> {
                List<Seat> seatsForSection = seats.stream().filter(seat -> seat.getSectionId() == section.getSectionId()
                                                                    && seat.getRow() == row)
                                                           .collect(Collectors.toList());

                if (!seatsForSection.isEmpty()) {
                    seatsForSection.forEach( seat -> {
                        if (Objects.nonNull(seat.getPassengerID())) {
                            System.out.print(String.format("%s[%s]", seat.getPassengerID(), seat.getType().getCode()));
                        } else {
                            System.out.print(String.format("[%s]", seat.getType().getCode()));
                        }
                        System.out.print("\t");
                    });
                } else {
                    IntStream.range(0,section.getColCount()).forEach(col -> System.out.print("\t"));
                }
            });
            System.out.println();
        });
    }
}
