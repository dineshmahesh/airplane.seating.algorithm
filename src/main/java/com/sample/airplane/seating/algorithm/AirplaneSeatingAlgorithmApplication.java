package com.sample.airplane.seating.algorithm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.airplane.seating.algorithm.exception.SeatingAlgorithmErrors;
import com.sample.airplane.seating.algorithm.exception.SeatingAlgorithmException;
import com.sample.airplane.seating.algorithm.factory.SeatingAlgorithmFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static com.sample.airplane.seating.algorithm.validator.SeatingAlgorithmValidator.validateSeatConfig;
import static com.sample.airplane.seating.algorithm.validator.SeatingAlgorithmValidator.validatePassengerCount;
import static com.sample.airplane.seating.algorithm.validator.SeatingAlgorithmValidator.validateSeatAndPassengerCount;

@SpringBootApplication
public class AirplaneSeatingAlgorithmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirplaneSeatingAlgorithmApplication.class, args);

		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Seat Layout configuration");
			String seatConfigString = sc.nextLine();
			ObjectMapper mapper = new ObjectMapper();
			Integer[][] seatConfig = mapper.createParser(seatConfigString).readValueAs(Integer[][].class);
			System.out.println(String.format("Entered Seat Layout: %s", Arrays.deepToString(seatConfig)));

			System.out.println("Enter number of passengers for reservation");
			int totalPassenger = sc.nextInt();
			System.out.println(String.format("Entered passengers count: %s", totalPassenger));

			// Validate necessary details
			validateSeatConfig(seatConfig);
			validatePassengerCount(totalPassenger);
			validateSeatAndPassengerCount(totalPassenger, getTotalSeats(seatConfig));

			//Allocate Seats to Passenger and Print Seats
			SeatingAlgorithmFactory seatingAlgorithmFactory = new SeatingAlgorithmFactory();
			seatingAlgorithmFactory.getAlgorithm("Airplane").allocateSeat(seatConfig, totalPassenger);
		} catch (IOException e) {
			e.printStackTrace();
			throw new SeatingAlgorithmException(SeatingAlgorithmErrors.ENTER_VALID_CONFIG_FORMAT.getError());
		} catch (Exception e) {
			e.printStackTrace();
			throw new SeatingAlgorithmException(SeatingAlgorithmErrors.UNKNOWN_ERROR_OCCURRED.getError());
		}
	}

	private static int getTotalSeats(Integer[][] seatConfig) {
		int totalSeats = 0;
		for (Integer[] integers : seatConfig) {
			int val = (integers[0] * integers[1]);
			totalSeats += val;
		}
		return totalSeats;
	}
}
