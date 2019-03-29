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
