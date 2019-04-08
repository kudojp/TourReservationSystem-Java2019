/**
 * 
 */
package edu.ncsu.csc216.travel.model.office;

/**
 * DuplicateClientException class which is used which is used  when a duplicated client is attempted to be made.
 * @author dkudo
 *
 */
public class DuplicateClientException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructs DuplicateException with a default message.
	 */
	public DuplicateClientException() {
		this("Client is already registered.");
	}

	/**
	 * Constructs DulicateException with a given message.
	 * @param message : message of this Exception
	 */
	public DuplicateClientException(String message) {
		super(message);
	}


}
