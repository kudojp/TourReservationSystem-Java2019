/**
 * 
 */
package edu.ncsu.csc216.travel.model.vacation;

import java.time.LocalDate;

/**
 * Class of Educational Tour
 * @author dkudo
 *
 */
public class EducationalTrip extends Tour {
	
	/** prefix which represents EducationalTrip */
	private static String prefix = "ED-";

	/**
	 * Constructs EducationalTrip object
	 * @param name : name of the EducationalTrip
	 * @param start : start time of the EducationalTrip
	 * @param duration : duration of the Educational Trip
	 * @param basePrice : basePrice of the EducationalTrip
	 * @param capacity : capacity of the EducationalTrip
	 * @throws IllegalArgumentException : if any parameters are not valid (including the parameter corresponding to capacity)
	 */
	public EducationalTrip(String name, LocalDate start, int duration, int basePrice, int capacity) {
		super(name, start, duration, basePrice, capacity);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.vacation.Tour#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.vacation.Tour#costFor(int)
	 */
	@Override
	public double costFor(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
