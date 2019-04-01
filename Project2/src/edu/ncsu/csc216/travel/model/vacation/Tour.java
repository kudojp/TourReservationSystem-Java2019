/**
 * 
 */
package edu.ncsu.csc216.travel.model.vacation;

import java.time.LocalDate;

import edu.ncsu.csc216.travel.list_utils.SimpleArrayList;
import edu.ncsu.csc216.travel.model.participants.Client;

/**
 * Tour abstract class which is extended by 3 subclasses : EducationalTrip, LandTour, and RiverCruise classes.
 * @author dkudo
 *
 */
public abstract class Tour implements Comparable<Tour> {
	/** name of this Tour */
	private String name;
	/** start time of this Tour */
	private LocalDate start;
	/** duration of this event */
	private int duration;
	/** original capacity of this Tour */
	private int capacity;
	/** whether this Tour's capacity has been fixed and cannot extended anymore. */
	private boolean capacityFixed;
	/** base price of this Tour */
	private int basePrice;
	/** number of decided participants of this Tour */
	private int numParticipants;
	/** list of Reservations made on this Tour */
	private SimpleArrayList<Reservation> res;
	
	/**
	 * Constructs Tour object.
	 * @param name : name of the Tour
	 * @param start : start time of the Tour
	 * @param duration : duration of the Tour
	 * @param basePrice : basePrice of the Tour
	 * @param capacity : capacity of the Tour
	 * @throws IllegalArgumentException : if any parameters are not valid 
	 */
	public Tour(String name, LocalDate start, int duration, int basePrice, int capacity) {
		// The constructor should throw an IllegalArgumentException if any parameters are not valid 
		// (including the parameter corresponding to capacity).
		
		// also, set capacityFixed = True only in ED, otherwise False
		
		this.name = name;
		this.start = start;
		this.duration = duration;
		this.basePrice = basePrice;
		this.capacity = capacity;
	}
	
	/**
	 * Compares the given Tour object with this Tour object
	 * @return −1 (if the given is smaller than this), 0 (if the given is equal to this), 1(if given is larger than this)
	 * @param another : another Tour object to be compared   
	 */
	public int compareTo(Tour another) {
		
		// If two tours have the same start date, those two are ordered according to their names
		// (where the comparison is made without regard to case). 
		// If two tours have the same start date and the same name (ignoring case),
		// they are ordered by their durations. No single tour is initially selected. 
		return 0;
	}
	
	/**
	 * Sets the capacity to given integer.
	 * @param capacity : capacity which this Tour's capacity should be set on
	 * @throws CapacityException : //TODO
	 */
	protected void setCapacity(int capacity) throws CapacityException{
		//PASS
	}
	
	/**
	 *  Returns the number spaces on this tour not yet reserved
	 * @return : the number of left spaces
	 */
	public int numberOfClientReservations() {
		return 0;
	}
	
	/**
	 * Returns the number of spaces left.
	 * @return : number of spaces left
	 */
	public int spacesLeft() {
		return 0;
	}
	
	/**
	 * Returns the name of this Tour.
	 * @return the name of this Tour
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the start date of this Tour.
	 * @return the start date
	 */
	public LocalDate getStartDate() {
		return start;
	}
	
	/**
	 * Returns the End date of this Tour.
	 * @return the end date
	 */
	public LocalDate getEndDate() {
		return null;
	}

	/**
	 * Returns the duration of this Tour
	 * @return the duration of this Tour.
	 */
	public int getDuration() {
		return this.duration;
	}

	/**
	 * Returns the capacity of this Tour.
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Returns whether the capacity of this Tour is already fixed and cannot be extended.
	 * @return the capacityFixed : True if capacity is already fixed.
	 */
	public boolean isCapacityFixed() {
		return capacityFixed;
	}

	/**
	 * Returns the basePrice of this Tour
	 * @return the basePrice
	 */
	public int getBasePrice() {
		return basePrice;
	}

	/**
	 * Returns Reservation object at given index.
	 * @param i : index for searching
	 * @return Reservation object searched
	 */
	public Reservation getReservation(int i) {
		return null;
	}

	/**
	 * Fix the capacity since when it is doubled once.
	 * (Used only by Educational trip)
	 */
	public void fixCapacity() {
		this.capacityFixed = true;
	}
	
	/**
	 * Returns the summary description of this Tour.
	 * @return : summary of this Tour
	 */
	public String summaryInfo() {
		return "";
	}
	
	/**
	 * Returns the hashCode of this Tour.
	 * Used in equals() method.
	 * @return : hashCode of this Tour
	 */
	public int hashCode() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		//TODO
		return false;
	}
	
	/**
	 * Returns array including all data of this Tour.
	 * @return : array representing this Tour
	 */
	public Object[] getAllData() {
		return null;
	}
	
	/**
	 * Returns an array of strings representing the client’s reservations.
	 * @return Array of strings each of them represents each reservation.
	 */
	public String[] listOfReservations() {
		// The lines shown in Figure 13 of [UC8,S2] illustrates appropriate formatting for the strings in the array. 
		// The return value should not be null, even if the tour has no reservations.
		return null;
	}
	
	/**
	 * Returns the total cost of this Tour for a given number of people.
	 * @param i : party size
	 * @return : total cost for this tour
	 */
	// Child classes should define this method
	public abstract double costFor(int i);
	
	
	/**
	 * Create new reservations of the given number of party including a given Client
	 * @param c : Client who reserved this Tour
	 * @param i : number of parties including the Client
	 * @return : Reservation object which is by the party
	 * @throws CapacityException : if the tour cannot accommodate the number of people in the reservation party
	 * @throws IllegalArgumentException : if any of parameters is invalid.
	 */
	public Reservation createReservationFor(Client c, int i) throws CapacityException {
		//Should throw a CapacityException if the tour cannot accommodate the number of people in the reservation party ([UC10, E1]) and an IllegalArgumentException if any parameters are illegal.
		//should ask the corresponding clients to add the reservation to their lists of reservations.
		//EducationalTrip.createReservation() should override the parent’s method in order to attempt expanding the capacity when needed. 
		return null;
	}
	
	/** 
	 * Adds Reservation object to this Tour's reservation list
	 * This is used when the Reservations are loaded in from a file.
	 * @param res : Reservation object to be added
	 * @return : Reservation object which is added
	 * @throws CapacityException : if the tour cannot accommodate the number of people in the reservation party
	 * @throws IllegalArgumentException : if parameter is invalid.
	 */
	public Reservation addOldReservation(Reservation res) throws CapacityException {
		//Should throw a CapacityException if the tour cannot accommodate the number of people in the reservation party ([UC10, E1]) and an IllegalArgumentException if any parameters are illegal.Should throw a CapacityException if the tour cannot accommodate the number of people in the reservation party ([UC10, E1]) and an IllegalArgumentException if any parameters are illegal.
		//should ask the corresponding clients to add the reservation to their lists of reservations.
		//This method should not be overridden under the assumption that any capacity expansion would have already taken place when the reservation was initially created.
		return null;
	}
	
	/**
	 * Cancels the given Reservation from the Reservation list of this Tour.
	 * @param res Reservation object which should be cancelled
	 */
	public void cancelReservation(Reservation res) {
		//pass
	}
	

	
	

}
