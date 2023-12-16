package com.bridgelabz.cabinvoice;

import java.util.ArrayList;
import java.util.List;

public class MultipleRides {

	private List<Ride> rides = new ArrayList<>();

	public void addRide(Ride ride) {
		rides.add(ride);
	}

	public List<Ride> getRides() {
		return rides;
	}
}
