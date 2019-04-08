/**
 * 
 */
package edu.ncsu.csc216.travel.model.vacation;

import java.time.LocalDate;

/**
 * RiveerCruise class
 * @author dkudo
 *
 */
public class RiverCruise extends Tour {
	
	/** prefix which represents EducationalTrip */
	private static String prefix = "RC-";

	/**
	 * Constructs RiverCruise object.
	 * @param name : name of the RiverCruise
	 * @param start : start time of the RiverCruise
	 * @param duration : duration of the RiverCruise
	 * @param basePrice : basePrice of the RiverCruise
	 * @param capacity : capacity of the RiverCruise
	 * @throws IllegalArgumentException : if any parameters are not valid (including the parameter corresponding to capacity)
	 */
	public RiverCruise(String name, LocalDate start, int duration, int basePrice, int capacity) {
		super(name, start, duration, basePrice, capacity);
		
		// RiverCuise cannot double its capacity
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
		// For river cruises, the cost is base cost X number of people in party for parties of an even number of people. 
		// For parties of an odd number of people, the cost is the same except for a 50% surcharge for one of the people. 
		// For example, suppose a river cruise has a base cost of $1000. Then the cost of a reservation for 4 people is $4000, 
		// but the cost of a party of five people is $5500.
		return super.getBasePrice() * i + super.getBasePrice() / 2. * (i % 2);
	}
	
	

}
