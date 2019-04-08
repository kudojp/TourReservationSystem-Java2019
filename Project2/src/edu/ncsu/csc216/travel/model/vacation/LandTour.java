/**
 * 
 */
package edu.ncsu.csc216.travel.model.vacation;

import java.time.LocalDate;

/**
 * LandTour Class
 * @author dkudo
 *
 */
public class LandTour extends Tour {
	
	/** prefix which represents EducationalTrip */
	private static String prefix = "LT-";

	/**
	 * Constructs LandTour object
	 * @param name : name of this LandTour
	 * @param start : start time of this LandTour
	 * @param duration : duration of this LandTour
	 * @param basePrice : basePrice of this LandTour
	 * @param capacity : capacity of this LandTour
	 * @throw IllegalArgumentException : if any parameters are not valid (including the parameter corresponding to capacity)
	 */
	public LandTour(String name, LocalDate start, int duration, int basePrice, int capacity) {
		super(name, start, duration, basePrice, capacity);
		
		// Land tour cannot double the capacity
		super.fixCapacity();
	}
	
	

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.vacation.Tour#getName()
	 */
	@Override
	public String getName() {
		return prefix + super.getName();
	}



	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.vacation.Tour#costFor(int)
	 */
	@Override
	public double costFor(int i) {
		// For land tours, the cost is base price X party size except for parties of size 1. 
		// For single-person parties, the cost is base price + 25% surcharge. For example, 
		// suppose a land tour has a base cost of $1000. Then the cost of a reservation for two people is $2000, but the cost of a party of one is $1250.
		
		if (i == 1) {
			return super.getBasePrice() * 1.25;
		}
		
		return super.getBasePrice() * i;
	}

}
