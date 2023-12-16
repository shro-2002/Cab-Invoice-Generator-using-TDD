package com.bridgelabz.cabinvoice;

import java.util.List;

/*
 * @Description - To create a InvoiceGenerator class to calculate the total fare for the journey
 * 
 * @Properties - COST_PER_KM, COST_PER_MINUTE, MINIMUM_FARE
 * 
 * @Methods - CalculateFare, MultipleRidesFare, InvoiceSummary
 */
public class InvoiceGenerator {
	private static final double COST_PER_KM = 10.0;
	private static final double COST_PER_MINUTE = 1.0;
	private static final double MINIMUM_FARE = 5.0;

	/*
	 * @Description - Calculate the total fare for a single ride
	 * 
	 * @params: double distance, double time
	 * 
	 * @return: double totalfare
	 */
	public double CalculateFare(double distance, double time) {
		double totalfare = distance * COST_PER_KM + time * COST_PER_MINUTE;
		return Math.max(MINIMUM_FARE, totalfare);
	}

	/*
	 * @Description - Calculate the total fare for multiple rides
	 * 
	 * @params: List<Ride> rides
	 * 
	 * @return: double totalfare
	 */
	public double MultipleRidesFare(List<Ride> rides) {
		double totalfare = 0;
		for (Ride ride : rides)
			totalfare += CalculateFare(ride.getDistance(), ride.getTime());
		return totalfare;
	}

	/*
	 * @Description - Calculate the total fare, total number of rides and average
	 * fare per ride for multiple rides
	 * 
	 * @params: List<Ride> rides
	 * 
	 * @return: Invoice
	 */
	public Invoice InvoiceSummary(List<Ride> rides) {
		int totalride = 0;
		double totalFare = 0;
		for (Ride ride : rides) {
			totalride += 1;
			totalFare += CalculateFare(ride.getDistance(), ride.getTime());
		}

		double avgFare = totalFare / totalride;

		return new Invoice(totalride, totalFare, avgFare);
	}

}