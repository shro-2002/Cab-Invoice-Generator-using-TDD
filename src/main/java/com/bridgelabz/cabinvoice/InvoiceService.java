package com.bridgelabz.cabinvoice;

import java.util.List;

/*
 * @Description - InvoiceService class to generate invoice of the journey for a particular user
 * 
 * @Properties - rideRepository, invoiceGenerator
 * 
 * @Methods - generateInvoice
 */
public class InvoiceService {
	private RideRepository rideRepository;
	private InvoiceGenerator invoiceGenerator;

	/*
	 * @Description - Initializing the rideRepository and invoiceGenerator
	 * 
	 * @params: RideRepository rideRepository, InvoiceGenerator invoiceGenerator
	 * 
	 * @return: No return value
	 */
	public InvoiceService(RideRepository rideRepository, InvoiceGenerator invoiceGenerator) {
		this.rideRepository = rideRepository;
		this.invoiceGenerator = invoiceGenerator;
	}

	/*
	 * @Description - generate invoice of the journey for a particular user
	 * 
	 * @params: String userId
	 * 
	 * @return: Invoice
	 */
	public Invoice generateInvoice(String userId) {
		List<Ride> userRides = rideRepository.getRides(userId);

		if (userRides == null || userRides.isEmpty()) {
			throw new IllegalArgumentException("No rides found for the given user ID");
		}

		return invoiceGenerator.InvoiceSummary(userRides);
	}
}
