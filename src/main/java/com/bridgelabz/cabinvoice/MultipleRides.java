package com.bridgelabz.cabinvoice;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description -  MultipleRides class to store the list of rides
 * 
 * @Properties - rides
 * 
 * @Methods - addRide, getRides
 */
public class MultipleRides {

	private List<Ride> rides = new ArrayList<>();

	/*
	 * @Description - To create a method to add rides to the list
	 * 
	 * @params: Ride ride
	 * 
	 * @return: No return value
	 */
	public void addRide(Ride ride) {
		rides.add(ride);
	}

	/*
	 * @Description - To create a getter method of rides
	 * 
	 * @params: No parameters
	 * 
	 * @return: List<Ride> rides
	 */
	public List<Ride> getRides() {
		return rides;
	}
}
