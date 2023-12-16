package com.bridgelabz.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InvoiceTest {

	InvoiceGenerator invoiceGenerator;

	@BeforeEach
	void setUp() throws Exception {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void calculateFareForSingleRide() {
		double fare = invoiceGenerator.CalculateFare(5, 30);
		assertEquals(80.0, fare);
		double faremin = invoiceGenerator.CalculateFare(0.3, 0.4);
		assertEquals(5.0, faremin);
	}

	@Test
	public void calculateFareForMultipleRides() {
		List<Ride> rides = Arrays.asList(
				new Ride(5, 30), 
				new Ride(2, 15), 
				new Ride(8, 45)
				);
		double totalFare = invoiceGenerator.calculateAggregateTotal(rides);
		assertEquals(140.0, totalFare);
	}

}
