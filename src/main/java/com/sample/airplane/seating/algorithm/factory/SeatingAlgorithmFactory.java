package com.sample.airplane.seating.algorithm.factory;

public class SeatingAlgorithmFactory {
    public SeatingAlgorithm getAlgorithm(String seatingType) {
        if (seatingType.equals("Airplane")) {
            return new AirplaneSeatingAlgorithm();
        }
        return null;
    }
}
