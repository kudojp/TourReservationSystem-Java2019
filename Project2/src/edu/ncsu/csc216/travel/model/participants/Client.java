/**
 * 
 */
package edu.ncsu.csc216.travel.model.participants;

import edu.ncsu.csc216.travel.list_utils.SimpleArrayList;
import edu.ncsu.csc216.travel.model.vacation.Reservation;

/**
 * Client class which represents each client of this company
 * @author dkudo
 */
public class Client {
	
	/** name of this client */
	private String name;
	/** contact info of this client */
	private String contact;
	/** reservations of this client */
	private SimpleArrayList<Reservation> myReservations;

	/**
	 * Constructs new Client objects with the name and contact info.
	 *  If any actual parameters to a Client method are illegal, the method should throw an IllegalArgumentException
	 * @param name : name of the client
	 * @param contact : contact info of the client
	 * @throws IllegalArgumentExcepiton : if any of parameters are illegal.
	 */
	public Client(String name, String contact) {
		
		// If any actual parameters to a Client method are illegal 
		//(such as names not starting with alphabetic characters or indexes out of bounds),
		//the method should throw an IllegalArgumentException
		
		if (name == null || name.equals("")) {
			throw new IllegalArgumentException("Name cannot be blank.");
		}
		
		if (!Character.isLetter(name.charAt(0))) {
			throw new IllegalArgumentException("Client name must start with an alphabetic character.");
		}
		
		if (contact == null || contact.equals("")) {
			throw new IllegalArgumentException("Contact cannot be blank.");
		}
		
		this.name = name;
		this.contact = contact;
		this.myReservations = new SimpleArrayList<Reservation>();
	}

	/**
	 * Returns the name of this client.
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the contact info of this 
	 * @return the contact of this  client.
	 */
	public String getContact() {
		return this.contact;
	}

	/**
	 * Returns the number of tour reservations of this client.
	 * @return the number of reservations
	 */
	public int getNumberOfReservations() {
		return 0;
	}
	
	/**
	 * Returns the client’s reservation at the given position, where position numbering starts at 0.
	 * @param i : index of Reservation to be returned
	 * @return the reservation at given index
	 */
	public Reservation getReservation(int i) {
		return null;
	}
	
	/**
	 * Returns number of total reservation cost by this client.
	 * @return number of total reservation
	 */
	public int totalReservationCost() {
		return 0;
	}
	
	/**
	 * Adds a Reservation object to the this Client’s list.
	 * Throws an IllegalArgumentException if the client for the reservation is not this client.
	 * Note: This method should not attempt to add the reservation to the corresponding tour.
	 * @param res : Reservation object to be added
	 * @throws IllegalArgumentException : if the client for the reservation is not for this client
	 */
	public void addReservation(Reservation res) {
		//pass
	}
	
	
	/**
	 * Cancels a given reservation.
	 * @param res : reservation to be removed
	 */
	public void cancelReservation(Reservation res) {
		//pass
	}
	

	/**
	 * Sets the name of this client
	 * @param name the name to set
	 * @throws IllegalArgumentException : if a parameter is illegal.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * TODO
	 * @return : TODO
	 */
	public String[] listOfReservations() {
		return null;
	}
	
	
	/**
	 * Returns String summary of this Client.
	 * @return : summary 
	 */
	public String summaryInfo() {
		return this.name + " (" + this.contact + ")";
	}
	
	
	/**
	 * Returns hashCode of this Client object.
	 * @return : hashCode 
	 * 
	 */
	public int hashCode() {
		return 0;
	}
}
