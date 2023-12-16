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

	/*
	 * @Description - Initializing the distance and time of the journey
	 * 
	 * @params: double distance, double time
	 * 
	 * @return: No return value
	 */
	public Ride(double distance, double time) {
		this.distance = distance;
		this.time = time;
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
}
