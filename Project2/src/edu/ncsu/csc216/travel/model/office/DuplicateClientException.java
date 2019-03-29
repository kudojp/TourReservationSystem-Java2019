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

	/** serialVersionUID used for this Exception */
	private static final long serialVersionUID = 1L;

	/**
	 * Created DuplicatedClienException with a default error message.
	 */
	public DuplicateClientException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates DuplicatedClientException with a given error message.
	 * @param message : error message
	 */
	public DuplicateClientException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
