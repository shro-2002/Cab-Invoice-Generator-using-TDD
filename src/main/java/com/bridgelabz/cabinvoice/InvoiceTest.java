package com.bridgelabz.cabinvoice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * @Description - TDD for Cab Invoice Generator
 * 
 * @Properties - invoiceGenerator
 * 
 * @Methods - setUp, calculateFareForSingleRide, calculateFareForMultipleRides, generateInvoice_ShouldReturnCorrectSummary
 */
class InvoiceTest {

	InvoiceGenerator invoiceGenerator;

	/*
	 * @Description - To create a setUp method to initialize the object
	 * 
	 * @params: No parameters
	 * 
	 * @return: No return value
	 */
	@BeforeEach
	void setUp() throws Exception {
		invoiceGenerator = new InvoiceGenerator();
	}

	/*
	 * @Description - Asserting the calculated fare with the expected fare for a
	 * single ride
	 * 
	 * @params: No parameters
	 * 
	 * @return: No return value
	 */
	@Test
	public void TestFareForSingleRide() {
		double fare = invoiceGenerator.CalculateFare(5, 30);
		assertEquals(80.0, fare);
		double faremin = invoiceGenerator.CalculateFare(0.3, 0.4);
		assertEquals(5.0, faremin);
	}

	/*
	 * @Description - Asserting the calculated fare with the expected fare for
	 * multiple rides
	 * 
	 * @params: No parameters
	 * 
	 * @return: No return value
	 */
	@Test
	public void TestFareForMultipleRides() {
		List<Ride> rides = Arrays.asList(

				new Ride(5, 30), new Ride(2, 15), new Ride(8, 45)

		);
		double totalFare = invoiceGenerator.MultipleRidesFare(rides);
		assertEquals(240.0, totalFare);
	}

	/*
	 * @Description - Asserting Invoice Summary with the expected summary
	 * 
	 * @params: No parameters
	 * 
	 * @return: No return value
	 */
	@Test
	void TestInvoice() {
		List<Ride> rides = Arrays.asList(new Ride(5, 25), new Ride(3, 15), new Ride(4, 30));

		Invoice summary = invoiceGenerator.InvoiceSummary(rides);

		assertEquals(3, summary.getTotalRides());
		assertEquals(190.0, summary.getTotalFare(), 0.0);
		assertEquals(63.33, summary.getAverageFarePerRide(), 0.01);

	}

	void TestInvoiceService() {
		// Create sample data
		RideRepository rideRepository = new RideRepository();
		InvoiceService invoiceService = new InvoiceService(rideRepository, invoiceGenerator);

		rideRepository.addRides("user1", Arrays.asList(new Ride(5.0, 25), new Ride(3.0, 15), new Ride(7.0, 30)));

		Invoice invoice = invoiceService.generateInvoice("user1");

		assertEquals(3, invoice.getTotalRides());
		assertEquals(145.0, invoice.getTotalFare(), 0.0);
		assertEquals(48.33, invoice.getAverageFarePerRide(), 0.01);
	}
}
