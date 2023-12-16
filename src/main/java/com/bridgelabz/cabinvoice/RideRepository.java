package com.bridgelabz.cabinvoice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Description - RideRepository class to store the list of rides for a particular user
 * 
 * @Properties - userRides
 * 
 * @Methods - addRides, getRides
 */
public class RideRepository {

	private Map<String, List<Ride>> userRides;

	/*
	 * @Description - Initializing the userRides
	 * 
	 * @params: No parameters
	 * 
	 * @return: No return value
	 */
	public RideRepository() {
		this.userRides = new HashMap<>();
	}

	/*
	 * @Description - add list of rides for a particular user
	 * 
	 * @params: String userId, List<Ride> rides
	 * 
	 * @return: No return value
	 */
	public void addRides(String userId, List<Ride> rides) {
		userRides.put(userId, rides);
	}

	/*
	 * @Description - To create a getter method of rides
	 * 
	 * @params: String userId
	 * 
	 * @return: List<Ride> rides
	 */
	public List<Ride> getRides(String userId) {
		return userRides.get(userId);
	}
}
