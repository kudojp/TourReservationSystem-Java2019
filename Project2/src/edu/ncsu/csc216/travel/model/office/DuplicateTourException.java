/**
 * 
 */
package edu.ncsu.csc216.travel.model.office;

/**
 * DuplicateTourExeption class which is used when a duplicated exception is attempted to be made.
 * @author dkudo
 *
 */
public class DuplicateTourException extends Exception {

	/** SerialVersionUID used used in this exception*/
	private static final long serialVersionUID = 1L;

	/**
	 * Creates DuplicateTourException with a default message.
	 */
	public DuplicateTourException() {
		this("Tour is already registered.");
	}

	/**
	 * Created DuplicateTourMessage with a given message.
	 * @param message : error message
	 */
	public DuplicateTourException(String message) {
		super(message);
		
	}




}
