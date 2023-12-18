package com.bridgelabz.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bridgelabz.cabinvoice.Invoice;
import com.bridgelabz.cabinvoice.Ride;
import com.bridgelabz.cabinvoice.RideRepository;
import com.bridgelabz.cabinvoice.RideType;
import com.bridgelabz.invoicegenerator.InvoiceGenerator;
import com.bridgelabz.invoicegenerator.InvoiceService;

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
	public void testFareForSingleRide() {
		double fare = invoiceGenerator.calculateFare(5, 30, RideType.PREMIUM);
		assertEquals(135.0, fare);
		double faremin = invoiceGenerator.calculateFare(0.3, 0.4, RideType.NORMAL);
		assertEquals(faremin, 5.0);
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
	public void testFareForMultipleRides() {
		List<Ride> rides = Arrays.asList(

				new Ride(5, 30, RideType.NORMAL), new Ride(2, 15, RideType.PREMIUM), new Ride(8, 45, RideType.NORMAL)

		);
		double totalFare = invoiceGenerator.multipleRidesFare(rides);
		assertEquals(265.0, totalFare);
	}

	/*
	 * @Description - Asserting Invoice Summary with the expected summary
	 * 
	 * @params: No parameters
	 * 
	 * @return: No return value
	 */
	@Test
	void testInvoice() {
		List<Ride> rides = Arrays.asList(new Ride(5, 25, RideType.NORMAL), new Ride(3, 15, RideType.PREMIUM),
				new Ride(4, 30, RideType.NORMAL));

		Invoice summary = invoiceGenerator.invoiceSummary(rides);

		assertEquals(3, summary.getTotalRides());
		assertEquals(220.0, summary.getTotalFare(), 0.0);
		assertEquals(73.33, summary.getAverageFare(), 0.01);

	}

	/*
	 * @Description - Asserting Invoice Summary with the expected summary for a
	 * particular user
	 * 
	 * @params: No parameters
	 * 
	 * @return: No return value
	 */
	@Test
	void TestInvoiceService() {
		RideRepository rideRepository = new RideRepository();

		rideRepository.addRides("user1", Arrays.asList(new Ride(5, 25, RideType.NORMAL),
				new Ride(3, 15, RideType.PREMIUM), new Ride(7, 30, RideType.NORMAL)));

		InvoiceService invoiceService = new InvoiceService(rideRepository, invoiceGenerator);

		Invoice invoice = invoiceService.generateInvoice("user1");

		assertEquals(3, invoice.getTotalRides());
		assertEquals(250.0, invoice.getTotalFare());
		assertEquals(83.33, invoice.getAverageFare(), 0.01);
	}
}
