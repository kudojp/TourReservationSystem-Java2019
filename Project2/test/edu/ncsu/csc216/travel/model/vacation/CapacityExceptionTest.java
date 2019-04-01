/**
 * 
 */
package edu.ncsu.csc216.travel.model.vacation;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for CapacityException class
 * @author dkudo
 *
 */
public class CapacityExceptionTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.CapacityException#CapacityException()}.
	 */
	@Test
	public void testCapacityException() {
		CapacityException e = new CapacityException();
		assertEquals("Not enough space in selected tour for this party.", e.getMessage());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.CapacityException#CapacityException(java.lang.String)}.
	 */
	@Test
	public void testCapacityExceptionString() {
		CapacityException e = new CapacityException("my message");
		assertEquals("my message", e.getMessage());	}

}
