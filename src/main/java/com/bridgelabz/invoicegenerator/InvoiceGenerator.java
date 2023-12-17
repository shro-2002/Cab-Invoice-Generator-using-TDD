package com.bridgelabz.invoicegenerator;

import java.util.List;

import com.bridgelabz.cabinvoice.Invoice;
import com.bridgelabz.cabinvoice.Ride;
import com.bridgelabz.cabinvoice.RideRepository;
import com.bridgelabz.cabinvoice.RideType;

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

	private static final double PREMIUM_COST_PER_KM = 15.0;
	private static final double PREMIUM_COST_PER_MINUTE = 2.0;
	private static final double PREMIUM_MINIMUM_FARE = 20.0;

	/*
	 * @Description - Calculate the total fare for a single ride
	 * 
	 * @params: double distance, double time
	 * 
	 * @return: double totalfare
	 */
	public double CalculateFare(double distance, double time, RideType ride) {

		if (distance <= 0)
			throw new IllegalArgumentException("Distance should be greater than zero");
		if (time <= 0)
			throw new IllegalArgumentException("Time should be greater than zero");

		double costperkm = 0;
		double costperminute = 0;
		double minimumfare = 0;

		switch (ride) {
		case NORMAL:
			costperkm = COST_PER_KM;
			costperminute = COST_PER_MINUTE;
			minimumfare = MINIMUM_FARE;
			break;
		case PREMIUM:
			costperkm = PREMIUM_COST_PER_KM;
			costperminute = PREMIUM_COST_PER_MINUTE;
			minimumfare = PREMIUM_MINIMUM_FARE;
			break;

		default:
			throw new IllegalArgumentException("Invalid Ride Type");
		}

		double totalfare = distance * costperkm + time * costperminute;
		return Math.max(totalfare, minimumfare);
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
			totalfare += CalculateFare(ride.getDistance(), ride.getTime(), ride.getRide());
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
			totalFare += CalculateFare(ride.getDistance(), ride.getTime(), ride.getRide());
		}

		double avgFare = totalFare / totalride;

		return new Invoice(totalride, totalFare, avgFare);
	}

}