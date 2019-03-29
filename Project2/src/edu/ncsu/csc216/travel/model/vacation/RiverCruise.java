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
