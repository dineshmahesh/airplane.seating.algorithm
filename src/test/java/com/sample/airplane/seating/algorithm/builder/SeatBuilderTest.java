package com.sample.airplane.seating.algorithm.builder;

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
public class SeatBuilderTest {

    @Test
    void testSeatBuilder() {
        List<Seat> mockedSeats = mockSeats();
        SeatBuilder seatBuilder = new SeatBuilder(mockSection());
        List<Seat> seatList = seatBuilder.build();

        assertEquals(seatList.get(0).getType(), mockedSeats.get(0).getType());
        assertEquals(seatList.get(0).getSectionId(), mockedSeats.get(0).getSectionId());
        assertEquals(seatList.get(0).getRow(), mockedSeats.get(0).getRow());
        assertEquals(seatList.get(0).getColumn(), mockedSeats.get(0).getColumn());
        assertEquals(seatList.get(0).getPassengerID(), mockedSeats.get(0).getPassengerID());

        assertEquals(seatList.get(1).getType(), mockedSeats.get(1).getType());
        assertEquals(seatList.get(1).getSectionId(), mockedSeats.get(1).getSectionId());
        assertEquals(seatList.get(1).getRow(), mockedSeats.get(1).getRow());
        assertEquals(seatList.get(1).getColumn(), mockedSeats.get(1).getColumn());
        assertEquals(seatList.get(1).getPassengerID(), mockedSeats.get(1).getPassengerID());

        assertEquals(seatList.get(2).getType(), mockedSeats.get(2).getType());
        assertEquals(seatList.get(2).getSectionId(), mockedSeats.get(2).getSectionId());
        assertEquals(seatList.get(2).getRow(), mockedSeats.get(2).getRow());
        assertEquals(seatList.get(2).getColumn(), mockedSeats.get(2).getColumn());
        assertEquals(seatList.get(2).getPassengerID(), mockedSeats.get(2).getPassengerID());
    }

    private List<Seat> mockSeats() {
        Seat seat1 = new Seat(1, 1, 1,1, Type.WINDOW);
        Seat seat2 = new Seat(1, 1, 2,2, Type.MIDDLE);
        Seat seat3 = new Seat(1, 1, 3,3, Type.WINDOW);
        return Arrays.asList(seat1, seat2, seat3);
    }

    private List<Section> mockSection() {
        return Collections.singletonList(new Section(1, 1, 3));
    }
}
