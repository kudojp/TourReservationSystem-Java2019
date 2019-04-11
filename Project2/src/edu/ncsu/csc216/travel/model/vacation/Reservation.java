/**
 * 
 */
package edu.ncsu.csc216.travel.model.vacation;

import edu.ncsu.csc216.travel.model.participants.Client;

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
	private static int maxCode = 999999;
	/** confirmation code of this Reservation object */
	private String confirmationCode;
	/** number of people for this Reservation object*/
	private int numInParty;
	/** Cost of this Reservation */
	//private double cost;
	
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
	 * @throws IllegalArgumentException : if any parameter is invalid.
	 */
	public Reservation(Tour tour, Client client, int numInParty) {
		
		// create Reservation not from a file.
		if (tour == null || client == null || numInParty <= 0) {
			throw new IllegalArgumentException();
		}
		this.theTour = tour;
		this.theClient = client;
		this.numInParty = numInParty;
		this.confirmationCode = String.format("%06d", codeGenerator);
		
		
		codeGenerator += 1;
		if (codeGenerator == maxCode + 1) {
			codeGenerator = 0;
		}
	}
	
	/** Creates a “temporary” reservation with the parameter information (client, tour, number in party, then optional confirmation code). 
	 *  It is the responsibility of the Tour to determine whether it has the capacity to accommodate the reservation.
	 * @param tour : Tour object for this Reservation
	 * @param client : Client object of this Reservation
	 * @param numInParty : the number of party for this Reservation
	 * @param code : Confirmation code of this Reservation
	 * @throws IllegalArgumentException : if any parameter is invalid.
	 */
	public Reservation(Tour tour, Client client, int numInParty, int code) {
		if (tour == null || client == null || numInParty <= 0 || code < 0 || 999999 < code ) {
			throw new IllegalArgumentException();
		}
		this.theTour = tour;
		this.theClient = client;
		this.numInParty = numInParty;
		this.confirmationCode = String.format("%06d", code);
		
		// if the confirmation code from a file of this line is bigger than codeGenerator
		if (code >= codeGenerator) {
			codeGenerator = code + 1;
			if (codeGenerator == maxCode + 1) {
				codeGenerator = 0;
			}
		}
	
	}

	/**
	 * Returns the confirmationCode of this Reservation
	 * @return the confirmationCode
	 */
	public String getConfirmationCode() {
		return this.confirmationCode;
	}

	/**
	 * Returns the nameInParty of this Reservation
	 * @return the numInParty
	 */
	public int getNumInParty() {
		return this.numInParty;
	}

	/**
	 * returns the cost of this Reservation
	 * @return the cost
	 */
	public double getCost() {
		return this.theTour.costFor(this.numInParty);
	}

	/**
	 * Returns theTour object of this Reservation
	 * @return the theTour
	 */
	public Tour getTour() {
		return this.theTour;
	}

	/**
	 * Returns theCilent object of this Reservation
	 * @return the theClient
	 */
	public Client getClient() {
		return this.theClient;
	}
	
	/**
	 * Cancels this Reservation.
	 */
	public void cancel() {
		this.theClient.cancelReservation(this);
		this.theTour.cancelReservation(this);
	}
	
	/**
	 * Returns the String which represents the Tour of this Reservation.
	 * @return Tour description
	 */
	public String displayReservationTour() {
		//displays in Figure 13 of [UC8,S2] 
		//like  " 4 Tetterton Travels (James T) "
		return this.confirmationCode + String.format("%4d", this.getNumInParty()) + " " + this.getTour().summaryInfo();	
	}
	
	/**
	 * Returns the String which represents the Client of this Reservation.
	 * @return Client description
	 */
	public String displayReservationClient() {
		// Figure 14 of [UC9,S2] respectively
		return this.confirmationCode + String.format("%4d", this.getNumInParty()) + " " + this.getClient().summaryInfo();
	}
	
	/**
	 * Sets codeGenerator to 0. Used for testing only.
	 */
	public static void resetCodeGenerator() {
		//Sets codeGenerator to 0. Used for testing only.
		codeGenerator = 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmationCode == null) ? 0 : confirmationCode.hashCode());
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
		Reservation other = (Reservation) obj;
		if (confirmationCode == null) {
			if (other.confirmationCode != null)
				return false;
		} else if (!confirmationCode.equals(other.confirmationCode))
			return false;
		return true;
	}



}
