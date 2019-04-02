/**
 * 
 */
package edu.ncsu.csc216.travel.model.participants;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for Client class.
 * @author dkudo
 *
 */
public class ClientTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.participants.Client#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.participants.Client#Client(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testClient() {
		
		// if name is null
		Client c = null;
		try {
			c = new Client(null, "123");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c);
		}
		
		// if name is empty String
		try {
			c = new Client("", "123");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c);
		}
		
		//if name does not begin with an alphabetic character

		try {
			c = new Client("111 john", "123");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Client name must start with an alphabetic character.", e.getMessage());
		}
		
		// if contact is null
		try {
			c = new Client("a", null);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c);
		}
		
		// if contact is empty String
		try {
			c = new Client("a", "");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c);
		}
		
		// valid case
		c = new Client("a", "123");
		assertEquals("a", c.getName());
		assertEquals("123", c.getContact());
		
		
		
	}


	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.participants.Client#getNumberOfReservations()}.
	 */
	@Test
	public void testGetNumberOfReservations() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.participants.Client#getReservation(int)}.
	 */
	@Test
	public void testGetReservation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.participants.Client#totalReservationCost()}.
	 */
	@Test
	public void testTotalReservationCost() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.participants.Client#addReservation(edu.ncsu.csc216.travel.model.vacation.Reservation)}.
	 */
	@Test
	public void testAddReservation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.participants.Client#cancelReservation(edu.ncsu.csc216.travel.model.vacation.Reservation)}.
	 */
	@Test
	public void testCancelReservation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.participants.Client#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.participants.Client#listOfReservations()}.
	 */
	@Test
	public void testListOfReservations() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.participants.Client#summaryInfo()}.
	 */
	@Test
	public void testSummaryInfo() {
		Client c = new Client("a", "123");
		assertEquals("a", c.getName());
		assertEquals("123", c.getContact());
		
		assertEquals("a (123)", c.summaryInfo());
	}

}
