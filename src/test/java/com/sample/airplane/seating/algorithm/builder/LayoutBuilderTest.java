package com.sample.airplane.seating.algorithm.builder;

import com.sample.airplane.seating.algorithm.model.Layout;
import com.sample.airplane.seating.algorithm.model.Seat;
import com.sample.airplane.seating.algorithm.model.Section;
import com.sample.airplane.seating.algorithm.model.Type;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class LayoutBuilderTest {

    @Test
    void testLayoutBuilder() {
        Layout mockedLayout = mockLayout();
        Integer[][] config = new Integer[][]{{3,1}};
        LayoutBuilder builder = new LayoutBuilder(config);
        Layout layout = builder.build();

        assertEquals(layout.getSections().get(0).getSectionId(), mockedLayout.getSections().get(0).getSectionId());
        assertEquals(layout.getSections().get(0).getRowCount(), mockedLayout.getSections().get(0).getRowCount());
        assertEquals(layout.getSections().get(0).getColCount(), mockedLayout.getSections().get(0).getColCount());

        assertEquals(layout.getSeats().size(), mockedLayout.getSeats().size());
        assertEquals(layout.getSeats().get(0).getType(), mockedLayout.getSeats().get(0).getType());
        assertEquals(layout.getSeats().get(1).getType(), mockedLayout.getSeats().get(1).getType());
        assertEquals(layout.getSeats().get(2).getType(), mockedLayout.getSeats().get(2).getType());
    }

    private Layout mockLayout() {
        List<Section> sections = Collections.singletonList(new Section(1, 1, 3));

        Seat seat1 = new Seat(1, 1, 1,1, Type.WINDOW);
        Seat seat2 = new Seat(1, 1, 2,2, Type.MIDDLE);
        Seat seat3 = new Seat(1, 1, 3,3, Type.WINDOW);
        List<Seat> seats = Arrays.asList(seat1, seat2, seat3);

        return new Layout(sections, seats);
    }

}
