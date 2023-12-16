package com.bridgelabz.test;

public class InvoiceGenerator {
	private static final double COST_PER_KM = 10.0;
	private static final double COST_PER_MINUTE = 1.0;
	private static final double MINIMUM_FARE = 5.0;

	public double CalculateFare(double distance, double time) {
		double totalfare = distance * COST_PER_KM + time * COST_PER_MINUTE;
		return Math.max(MINIMUM_FARE, totalfare);
	}

}
