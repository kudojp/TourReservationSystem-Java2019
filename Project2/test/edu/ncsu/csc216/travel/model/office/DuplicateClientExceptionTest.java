/**
 * 
 */
package edu.ncsu.csc216.travel.model.office;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for DuplicateClientException class.
 * @author dkudo
 *
 */
public class DuplicateClientExceptionTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.DuplicateClientException#DuplicateClientException()}.
	 */
	@Test
	public void testDuplicateClientException() {
		DuplicateClientException e = new DuplicateClientException();
		assertEquals("Client is already registered.", e.getMessage());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.DuplicateClientException#DuplicateClientException(java.lang.String)}.
	 */
	@Test
	public void testDuplicateClientExceptionString() {
		DuplicateClientException e = new DuplicateClientException("my message");
		assertEquals("my message", e.getMessage());
	}
	


}
