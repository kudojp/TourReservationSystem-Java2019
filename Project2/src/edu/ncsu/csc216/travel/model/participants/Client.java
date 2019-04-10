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
	 * @throws IllegalArgumentException : if any of parameters are illegal.
	 */
	public Client(String name, String contact) {
		
		// If any actual parameters to a Client method are illegal 
		//(such as names not starting with alphabetic characters or indexes out of bounds),
		//the method should throw an IllegalArgumentException
		
		
		// name check
		if (name == null || name.trim().equals("")) {
			throw new IllegalArgumentException("Name cannot be blank.");
		}
		
		char nameChar = name.trim().charAt(0);
		
		
		if (!('a' <= nameChar && nameChar <= 'z') && !('A' <= nameChar && nameChar <= 'Z')) {
			throw new IllegalArgumentException("Client name must start with an alphabetic character.");
		}
		
		
		// contact check
		if (contact == null || contact.trim().equals("")) {
			throw new IllegalArgumentException("Contact cannot be blank.");
		}
		
		char contactChar = contact.trim().charAt(0);
		
		if (!('a' <= contactChar && contactChar <= 'z') && !('A' <= contactChar && contactChar <= 'Z')
				&& !('0' <= contactChar && contactChar <= '9')) {
			throw new IllegalArgumentException("Contact must start with an alphabetic or digit character.");
		}
		
		
		this.name = name.trim();
		this.contact = contact.trim();
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
		return this.myReservations.size();
	}
	
	/**
	 * Returns the client’s reservation at the given position, where position numbering starts at 0.
	 * @param i : index of Reservation to be returned
	 * @return the reservation at given index
	 * @throws IllegalArgumentException : if given index is out of 
	 */
	public Reservation getReservation(int i) {
		if (i < 0 || this.getNumberOfReservations() < i) {
			throw new IllegalArgumentException();
		}
		return this.myReservations.get(i);
	}
	
	/**
	 * Returns number of total reservation cost by this client.
	 * @return number of total reservation
	 */
	public int totalReservationCost() {
		int total = 0;
		for (int i = 0 ; i < this.getNumberOfReservations() ; i++) {
			total += this.myReservations.get(i).getCost();
		}
		return total;
	}
	
	/**
	 * Adds a Reservation object to the this Client’s list.
	 * Note: This method should not attempt to add the reservation to the corresponding tour.
	 * @param res : Reservation object to be added
	 * @throws IllegalArgumentException : if the client for the reservation is not for this client
	 */
	public void addReservation(Reservation res) {
		
		if (!res.getClient().equals(this)) {
			throw new IllegalArgumentException();
		}
		
		this.myReservations.add(res);
	}
	
	
	/**
	 * Cancels a given reservation.
	 * @param res : reservation to be removed
	 * @throws IllegalArgumentException : if the given object is not in the reservation list of this Tour.
	 */
	public void cancelReservation(Reservation res) {
		
		if (!this.myReservations.contains(res)) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0 ; i < this.myReservations.size() ; i++) {
			if (this.myReservations.get(i).equals(res)) {
				this.myReservations.remove(i);
			}
		}
	}
	
	
	/**
	 * Returns the array of String objects which represents Reservations made by this Client
	 * @return : String array with Reservation descriptions
	 */
	public String[] listOfReservations() {
		
		// Reference to UC9
		String[] list = new String[this.getNumberOfReservations()];
		for (int i = 0 ; i < this.getNumberOfReservations() ; i++) {
			list[i] = this.myReservations.get(i).getConfirmationCode() + " " + this.myReservations.get(i).displayReservationTour();
		}
		return list;
		
	}
	
	
	/**
	 * Returns String summary of this Client.
	 * @return : summary 
	 */
	public String summaryInfo() {
		return this.name + " (" + this.contact + ")";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Client other = (Client) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.toLowerCase().equals(other.contact.toLowerCase()))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.toLowerCase().equals(other.name.toLowerCase()))
			return false;
		return true;
	}
	
	
	
}
