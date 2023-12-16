package com.bridgelabz.cabinvoice;

/*
 * @Description - To create a Invoice class to store the total number of rides, total fare and average fare per ride
 * 
 * @Properties - totalRides, totalFare, averageFarePerRide
 * 
 * @Methods - Constructor, Getters
 */
public class Invoice {
	private int totalRides;
	private double totalFare;
	private double averageFarePerRide;

	/*
	 * @Description - To create a constructor of Invoice class
	 * 
	 * @params: int totalRides, double totalFare, double averageFarePerRide
	 * 
	 * @return: No return value
	 */
	public Invoice(int totalRides, double totalFare, double averageFarePerRide) {
		super();
		this.totalRides = totalRides;
		this.totalFare = totalFare;
		this.averageFarePerRide = averageFarePerRide;
	}

	/*
	 * @Description - To create a getter method of totalRides
	 * 
	 * @params: No parameters
	 * 
	 * @return: int totalRides
	 */
	public int getTotalRides() {
		return totalRides;
	}

	/*
	 * @Description - To create a getter method of totalFare
	 * 
	 * @params: No parameters
	 * 
	 * @return: double totalFare
	 */
	public double getTotalFare() {
		return totalFare;
	}

	/*
	 * @Description - To create a getter method of averageFarePerRide
	 * 
	 * @params: No parameters
	 * 
	 * @return: double averageFarePerRide
	 */
	public double getAverageFarePerRide() {
		return averageFarePerRide;
	}

}
