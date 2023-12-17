package com.bridgelabz.cabinvoice;

/*
 * @Description - Ride class to store the distance and time of the journey
 * 
 * @Properties - distance, time
 * 
 * @Methods - Constructor, Getters
 */
public class Ride {

	private double distance;
	private double time;
	private RideType ride;

	/*
	 * 
	 * @params: double distance, double time
	 * 
	 * @return: No return value
	 */
	public Ride(double distance, double time, RideType ride) {
		this.distance = distance;
		this.time = time;
		this.ride = ride;
	}

	/*
	 * @Description - To create a getter method of distance
	 * 
	 * @params: No parameters
	 * 
	 * @return: double distance
	 */
	public double getDistance() {
		return distance;
	}

	/*
	 * @Description - To create a getter method of time
	 * 
	 * @params: No parameters
	 * 
	 * @return: double time
	 */
	public double getTime() {
		return time;
	}

	/*
	 * @Description - To create a getter method of ride type
	 * 
	 * @params: No parameters
	 * 
	 * @return: RideType ride
	 */
	public RideType getRide() {
		return ride;
	}
}
