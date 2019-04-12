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
		
		
		if (name == null || name.trim().length() <= 0 || name.contains(":")) {
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
		
		this.name = name.trim();
		this.start = start;
		this.duration = duration;
		this.basePrice = basePrice;
		this.capacity = capacity;
		this.res = new SimpleArrayList<Reservation>();
		
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
				} else if (this.getDuration() > another.getDuration()) {
					return 1;
				}
			}
		}
		
		// if all of start dates, names, durations are the same...
		return 0;
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
		return this.start.plusDays(this.duration - 1);
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
	 * @throws IllegalArgumentException : if the index is out
	 */
	public Reservation getReservation(int i) {
		if (i < 0 || this.res.size() <= i) {
			throw new IllegalArgumentException();
		}
		return this.res.get(i);
	}

	
	/**
	 * Returns the summary description of this Tour.
	 * @return : summary of this Tour
	 */
	public String summaryInfo() {
		// reference to USE-CASE 9
		
		LocalDate date = this.getStartDate();
		return this.getName() + ": " 
				+ String.format("%02d", (int)date.getMonthValue()) + 
				"/" + String.format("%02d", (int)date.getDayOfMonth()) + "/" + String.format("%02d", (int)date.getYear() % 100) + " " + this.getDuration() + " days"; 
		
	}

	/**
	 * Returns array including all data of this Tour,
	 * which are {name, date, duration, cost, capacity}
	 * @return : array representing this Tour
	 */
	public Object[] getAllData() {
	// 1) Preemptively converting all values to Strings
	// 2) Trimming the name
	// 3) Manually inputting logic to format the date as: MM/DD/YYYY
	// 4) Adding "$" as a prefix to the base price
	// 5) Adding logic to add "*" to the end of the capacity if the capacity can still be expanded
		
		LocalDate date = this.getStartDate();
		String cap = "" + this.getCapacity();
		
		if (!this.isCapacityFixed()) {
			cap += "*";
		}
		
		
		Object[] ret = {this.getName(), String.format("%02d", (int)date.getMonthValue()) + "/" + String.format("%02d", (int)date.getDayOfMonth()) + "/" + String.format("%02d", (int)date.getYear() % 100),
						this.getDuration(), "$" + this.getBasePrice(), cap};
		return ret;
	}
		
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duration;
		result = prime * result + ((name == null) ? 0 : name.toLowerCase().hashCode());
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
		
		///// If the only kind is different, obj is considered to be equal
		//if (getClass() != obj.getClass())
		//return false;
		
		Tour other = null;
		try {
			other = (Tour) obj;
		} catch (ClassCastException e) {
			return false;
		}
		
		if (duration != other.duration)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.toLowerCase().equals(other.name.toLowerCase()))
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
			array[i] = this.res.get(i).displayReservationClient();
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
		
		if (c == null || i <= 0) {
			throw new IllegalArgumentException();
		}
		
		Reservation newRes = new Reservation(this, c, i);
		
		if (this.capacity >= this.numParticipants + i) {
			
			//add this new reservation to the Tour object
			this.res.add(newRes);
			//add this new reservation to the Client object
			c.addReservation(newRes);
			//add number of participants
			this.numParticipants += i;
			return newRes;
		}
		
		if (!this.isCapacityFixed() || this.spacesLeft() + this.getCapacity() >= i) {
			this.setCapacity(this.getCapacity() * 2);

			//add this new reservation to the Tour object
			this.res.add(newRes);
			//add this new reservation to the Client object
			c.addReservation(newRes);
			//add number of participants
			this.numParticipants += i;
			return newRes;
			
		}
		
		// in the case when there is no space
		newRes.cancel();
		throw new CapacityException();
	}
	
	
	
	
	/** 
	 * Adds Reservation object to this Tour's reservation list
	 * This is used when the Reservations are loaded in from a file.
	 * @param oldRes : Reservation object to be added
	 * @return : Reservation object which is added
	 * @throws CapacityException : if the tour cannot accommodate the number of people in the reservation party
	 * @throws IllegalArgumentException : if parameter is invalid.
	 */
	public Reservation addOldReservation(Reservation oldRes) throws CapacityException {
		// Should throw a CapacityException if the tour cannot accommodate the number of people in the reservation party ([UC10, E1]) 
		// IllegalArgumentException if any parameters are illegal.
		// should ask the corresponding clients to add the reservation to their lists of reservations.
		// This method should not be overridden under the assumption that any capacity expansion would have already taken place when the reservation was initially created.
		
		if (oldRes == null) {
			throw new IllegalArgumentException();
		}
		
		if (!oldRes.getTour().getName().substring(0, 2).equals(this.getName().substring(0, 2))) {
			throw new IllegalArgumentException();
		}
		
		if (oldRes.getNumInParty() > this.spacesLeft()){
			throw new CapacityException();
		}
		
		// add oldRes to the Reservation list of this Tour
		this.res.add(oldRes);
		// add oldRes to the list of a corresponding Client
		oldRes.getClient().addReservation(oldRes);
		// add number of participants
		this.numParticipants += oldRes.getNumInParty();
		return oldRes;
	}
	
	/**
	 * Cancels the given Reservation from the Reservation list of this Tour.
	 * @param res Reservation object which should be cancelled
	 * @throws IllegalArgumentException : if the given object is not in the reservation list of this Tour.
	 */
	public void cancelReservation(Reservation res) {
		
		if (!this.res.contains(res)) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0 ; i < this.res.size() ; i++) {
			//System.out.println( this.res.get(i).getTour().equals(res.getTour()));
			//System.out.println( this.res.get(i).getClient().equals(res.getClient()));
			if (this.res.get(i).equals(res)){
				// remove number of participants
				this.numParticipants -= res.getNumInParty();
				
				this.res.remove(i);
				//System.out.println(i);
				this.res.size();
			}
		}
	}
	
	/**
	 * Returns whether the capacity of this Tour is already fixed and cannot be extended.
	 * @return the capacityFixed : true if capacity is already fixed.
	 */
	public boolean isCapacityFixed() {
		return this.capacityFixed;
	}
	
	
	/**
	 * Sets the capacity to given integer.
	 * @param capacity : capacity which this Tour's capacity should be set on
	 * @throws CapacityException : if a user tries to set a capacity below the number of current participants,
	 * 								 or if the capacity is less than 1.
	 */
	protected void setCapacity(int capacity) throws CapacityException{
		if (capacity < this.numParticipants || capacity < 1 || this.isCapacityFixed()) {
			throw new CapacityException();
		}
		this.capacity = capacity;
		this.fixCapacity();
	}
	
	/**
	 * Fix the capacity when it would no longer be doubled.
	 */
	public void fixCapacity() {
		this.capacityFixed = true;
	}
}
