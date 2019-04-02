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
	private boolean capacityFixed = false;
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
		
		
		if (name == null || name.contentEquals("")) {
			throw new IllegalArgumentException("Tour name is invalid.");
		}
		
		
		if (start == null) {
			throw new IllegalArgumentException("Tour start date is invalid.");
		}
		
		if (duration <= 0) {
			throw new IllegalArgumentException("Tour duration is invalid.");
		}
		
		if (basePrice <= 0) {
			throw new IllegalArgumentException("Tour base price is invalid.");	
		}
		
		if (capacity <= 0) {
			throw new IllegalArgumentException("Tour capacity is invalid.");
		}
		
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
		// they are ordered by their durations. 
		
		// sorting by the start dates....
		if (this.start.isBefore(another.getStartDate())) {
			return -1;
		} else if (this.start.isAfter(another.getStartDate())) {
			return 1;
		} else {
			
			// sorting by the names...
			if (this.getName().toLowerCase().compareTo(another.getName().toLowerCase()) < 0) {
				return -1;
			} if (this.getName().toLowerCase().compareTo(another.getName().toLowerCase()) > 0) {
				return 1;
			} else {
				
				// sorting by the durations... 
				if (this.getDuration() < another.getDuration()) {
					return -1;
				} else if (this.getDuration() < another.getDuration()) {
					return 1;
				}
			}
		}
		
		// if all of start dates, names, durations are the same...
		return 0;
	}
	
	
	/**
	 * Sets the capacity to given integer.
	 * @param capacity : capacity which this Tour's capacity should be set on
	 */
	public void setCapacity(int capacity) throws CapacityException{
		this.capacity = capacity;
	}
	
	
	/**
	 *  Returns the number of Reservations
	 * @return : the number reservations
	 */
	public int numberOfClientReservations() {
		return this.res.size();
	}
	
	/**
	 * Returns the number of spaces left.
	 * @return : number of spaces left
	 */
	public int spacesLeft() {
		return this.capacity - this.numParticipants;
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
		return this.start;
	}
	
	/**
	 * Returns the End date of this Tour.
	 * @return the end date
	 */
	public LocalDate getEndDate() {
		return this.start.plusDays(this.duration);
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
	 * Returns the basePrice of this Tour
	 * @return the basePrice
	 */
	public int getBasePrice() {
		return this.basePrice;
	}

	/**
	 * Returns Reservation object at given index.
	 * @param i : index for searching
	 * @return Reservation object searched
	 */
	public Reservation getReservation(int i) {
		return this.res.get(i);
	}

	
	/**
	 * Returns the summary description of this Tour.
	 * @return : summary of this Tour
	 */
	public String summaryInfo() {
		// reference to USE-CASE 9
		
		return this.numParticipants + " " + this.getName() + " " 
				+ this.getStartDate() + " " + this.getDuration() + "days"; 
		
	}

	/**
	 * Returns array including all data of this Tour.
	 * @return : array representing this Tour
	 */
	public Object[] getAllData() {
		Object[] array = new Object[this.res.size()];
		for (int i = 0 ; i < this.res.size() ; i++) {
			array[i] = this.res.get(i);
		}
		return array;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duration;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		if (duration != other.duration)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

	

	/**
	 * Returns an array of strings representing the client’s reservations.
	 * @return Array of strings each of them represents each reservation.
	 */
	public String[] listOfReservations() {
		// The lines shown in Figure 13 of [UC8,S2] illustrates appropriate formatting for the strings in the array. 
		// The return value should not be null, even if the tour has no reservations.
		String[] array = new String[this.res.size()];
		for (int i = 0 ; i < this.res.size() ; i++) {
			array[i] = this.res.get(1).getClient().summaryInfo();
		}
		return array;
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
		
		if (this.capacity >= this.numParticipants + i) {
			this.numParticipants += i;
			return new Reservation(this, c, i);
		}
		
		// if capacity can be doubled and it becomes enough...
		if (!this.capacityFixed && this.capacity * 2 >= this.numParticipants + i) {
			//double capacity and switch CapacityFixed to true
			this.fixCapacity();
			this.numParticipants += i;
			return new Reservation(this, c, i);
		}
		
		// in the case when there is no space
		throw new CapacityException();
	}
	
	/** 
	 * Adds Reservation object to this Tour's reservation list
	 * This is used when the Reservations are loaded in from a file.
	 * @param newRes : Reservation object to be added
	 * @return : Reservation object which is added
	 * @throws CapacityException : if the tour cannot accommodate the number of people in the reservation party
	 * @throws IllegalArgumentException : if parameter is invalid.
	 */
	public Reservation addOldReservation(Reservation newRes) throws CapacityException {
		// Should throw a CapacityException if the tour cannot accommodate the number of people in the reservation party ([UC10, E1]) 
		// IllegalArgumentException if any parameters are illegal.
		//should ask the corresponding clients to add the reservation to their lists of reservations.
		//This method should not be overridden under the assumption that any capacity expansion would have already taken place when the reservation was initially created.
		
		if (newRes == null || newRes.getNumInParty() > this.capacity) {
			throw new IllegalArgumentException();
		}
		// add newRes to the Reservation list of this Tour
		this.res.add(newRes);
		// add newRes to the list of a corresponding Client
		newRes.getClient().addReservation(newRes);
		return newRes;
	}
	
	/**
	 * Cancels the given Reservation from the Reservation list of this Tour.
	 * @param res Reservation object which should be cancelled
	 */
	public void cancelReservation(Reservation res) {
		for (int i = 0 ; i < this.res.size() ; i++) {
			if (this.res.get(i).equals(res)){
				this.res.remove(i);
				break;
			}
		}
	}
	
	/**
	 * Returns whether the capacity of this Tour is already fixed and cannot be extended.
	 * @return the capacityFixed : true if capacity is already fixed.
	 */
	public boolean isCapacityFixed() {
		return capacityFixed;
	}
	
	/**
	 * Fix the capacity since when it is doubled once.
	 * (Used only by Educational trip)
	 */
	public void fixCapacity() {
		this.capacity = this.capacity * 2;
		this.capacityFixed = true;
	}
}
