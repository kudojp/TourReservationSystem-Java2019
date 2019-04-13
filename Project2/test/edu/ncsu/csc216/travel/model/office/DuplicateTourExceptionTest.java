/**
 * 
 */
package edu.ncsu.csc216.travel.model.office;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test class for DuplicateTourException class.
 * @author dkudo
 *
 */
public class DuplicateTourExceptionTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.DuplicateTourException#DuplicateTourException()}.
	 */
	@Test
	public void testDuplicateTourException() {
		DuplicateTourException e = new DuplicateTourException("my message");
		assertEquals("my message", e.getMessage());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.DuplicateTourException#DuplicateTourException(java.lang.String)}.
	 */
	@Test
	public void testDuplicateTourExceptionString() {
		DuplicateTourException e = new DuplicateTourException();
		assertEquals("Tour is already registered.", e.getMessage());
	}


}
