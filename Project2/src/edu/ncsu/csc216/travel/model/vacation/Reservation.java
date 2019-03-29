/**
 * 
 */
package edu.ncsu.csc216.travel.model.vacation;

import edu.ncsu.csc216.travel.model.participant.Client;

/**
 * Reservation class which represents the reservation by a Client
 * @author dkudo
 *
 */
public class Reservation {

	// If any parameters to a Reservation method are illegal, the method should throw an IllegalArgumentException.
	
	/** Generator which determines the confirmation code of the next reservation */
	private static int codeGenerator;
	/** Code which is the highest in all the Reservation objects */
	private static int maxCode;
	/** confirmation code of this Reservation object */
	private String confirmationCode;
	/** number of people for this Reservation object*/
	private int numInParty;
	/** Cost of this Reservation */
	private double cost;
	/** Tour of this Reservation */
	private Tour theTour;
	/** Client of this Reservation */
	private Client theClient;
	
	
	//Creates a “temporary” reservation with the parameter information (client, tour, number in party, then optional confirmation code).
	// It is the responsibility of the Tour to determine whether it has the capacity to accommodate the reservation.
	
	/** Creates a “temporary” reservation with the parameter information (client, tour, number in party, then optional confirmation code). 
	 *  It is the responsibility of the Tour to determine whether it has the capacity to accommodate the reservation.
	 * @param tour ; Tour object for this Reservation
	 * @param client : Client object of this Reservation
	 * @param numInParty : the number of party for this Reservation
	 */
	public Reservation(Tour tour, Client client, int numInParty) {
		//pass
		
	}
	
	/** Creates a “temporary” reservation with the parameter information (client, tour, number in party, then optional confirmation code). 
	 *  It is the responsibility of the Tour to determine whether it has the capacity to accommodate the reservation.
	 * @param tour : Tour object for this Reservation
	 * @param client : Client object of this Reservation
	 * @param numInParty : the number of party for this Reservation
	 * @param code : Confirmation code of this Reservation
	 */
	public Reservation(Tour tour, Client client, int numInParty, String code) {
		//pass
		
	}

	/**
	 * Returns the confirmationCode of this Reservation
	 * @return the confirmationCode
	 */
	public String getConfirmationCode() {
		return confirmationCode;
	}

	/**
	 * Returns the nameInParty of this Reservation
	 * @return the numInParty
	 */
	public int getNumInParty() {
		return numInParty;
	}

	/**
	 * returns the cost of this Reservation
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Returns theTour object of this Reservation
	 * @return the theTour
	 */
	public Tour getTour() {
		return theTour;
	}

	/**
	 * Returns theCilent object of this Reservation
	 * @return the theClient
	 */
	public Client getClient() {
		return theClient;
	}
	
	/**
	 * Cancels this Reservation.
	 */
	public void cancel() {
		//TODO
	}
	
	/**
	 * Returns the String which represents the Tour of this Reservation.
	 * @return : Tour description
	 */
	public String displayReservationTour() {
		//displays in Figure 13 of [UC8,S2] 
		return "";
	}
	
	/**
	 * Returns the String which represents the Client of this Reservation.
	 * @return Client description
	 */
	public String displayReservationClient() {
		// Figure 14 of [UC9,S2] respectively
		return "";
	}
	
	/**
	 * Sets codeGenerator to 0. Used for testing only.
	 */
	public static void resetCodeGenerator() {
		//Sets codeGenerator to 0. Used for testing only.
	}
	
	/**
	 * Returns the has Code of this Reservation object.
	 * Used for equals() method.
	 * @return : hashCode of this object.
	 */
	public int hashCode() {
		return 0;
	}
	
	/**
	 * Compares this Reservation with a given Object.
	 * @return true : if this object is equals to the given object
	 * TODO(What is equals??)
	 * @param another : a object given to be compared
	 */
	public boolean equals(Object another) {
		return false;
	}
	
	
}
