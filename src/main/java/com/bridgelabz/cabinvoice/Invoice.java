package com.bridgelabz.cabinvoice;

public class Invoice {
	private int totalRides;
	private double totalFare;
	private double averageFarePerRide;

	public Invoice(int totalRides, double totalFare, double averageFarePerRide) {
		super();
		this.totalRides = totalRides;
		this.totalFare = totalFare;
		this.averageFarePerRide = averageFarePerRide;
	}

	public int getTotalRides() {
		return totalRides;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public double getAverageFarePerRide() {
		return averageFarePerRide;
	}

	public void setTotalRides(int totalRides) {
		this.totalRides = totalRides;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public void setAverageFarePerRide(double averageFarePerRide) {
		this.averageFarePerRide = averageFarePerRide;
	}

}
