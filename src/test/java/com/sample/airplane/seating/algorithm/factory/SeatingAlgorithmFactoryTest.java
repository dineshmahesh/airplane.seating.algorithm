package com.sample.airplane.seating.algorithm.factory;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeatingAlgorithmFactoryTest {

    @Test
    void testGetAirplaneAlgorithmFactory() {
        SeatingAlgorithmFactory factory = new SeatingAlgorithmFactory();
        Assert.assertEquals(factory.getAlgorithm("Airplane").getClass(), AirplaneSeatingAlgorithm.class);
    }

    @Test
    void testGetInvalidAlgorithmFactoryTest() {
        SeatingAlgorithmFactory factory = new SeatingAlgorithmFactory();
        Assert.assertEquals(factory.getAlgorithm("Bus"), null);

    }
}
