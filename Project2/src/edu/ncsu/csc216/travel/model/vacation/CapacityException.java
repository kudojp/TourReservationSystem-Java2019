/**
 * 
 */
package edu.ncsu.csc216.travel.model.vacation;

/**
 * Capacity Exception which is thrown when there is an attempt to create a reservation that would fill a tour over its capacity.
 * @author dkudo
 *
 */
public class CapacityException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructs CapacityException with a default message.
	 */
	public CapacityException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructs CapacityException with a given message.
	 * @param message : message of this Exception
	 */
	public CapacityException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


}
