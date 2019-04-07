/**
 * 
 */
package edu.ncsu.csc216.travel.model.participants;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import edu.ncsu.csc216.travel.model.vacation.EducationalTrip;
import edu.ncsu.csc216.travel.model.vacation.Reservation;
import edu.ncsu.csc216.travel.model.vacation.Tour;

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
	 * Test method for cancelReservation()
	 */
	@Test
	public void testCancelReservation() {
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
	 * Test method for addReservation(), listOfReservation(), totalReservationCost(), getReservation()
	 */
	@Test
	public void testAddReservation() {
		
		Client c = new Client("a", "123");
		Client otherClient = new Client("b", "123");
		
		// valid1
		Tour et  = new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50);
		Reservation r = new Reservation(et, c, 3);
		try {
			c.addReservation(r);
		} catch(IllegalArgumentException e) {
			fail();
		}
		
		//vaild2
		Tour et2  = new EducationalTrip("name2", LocalDate.of(2019, 11, 12), 7, 500, 50);
		Reservation r2 = new Reservation(et2, c, 5);
		try {
			c.addReservation(r2);
		} catch(IllegalArgumentException e) {
			fail();
		}
		
		//invalid (client for the reservation is not for this client)
		Tour et3  = new EducationalTrip("name2", LocalDate.of(2019, 11, 11), 7, 500, 50);
		Reservation r3 = new Reservation(et3, otherClient, 7);
		try {
			c.addReservation(r3);
			fail();
		} catch(IllegalArgumentException e) {
			//pass
		}
		
		
		// test getNumberOfReservations
		assertEquals(2, c.getNumberOfReservations());
		
		// test getReservation()
		assertEquals(r, c.getReservation(0));
		assertEquals(r2, c.getReservation(1));
		
		// test listOfReservations()
		assertEquals("3 ED-name: 11/11/19 7 days", c.listOfReservations()[0]);
		assertEquals("5 ED-name2: 11/12/19 7 days", c.listOfReservations()[1]);
		
		// test totalReservationCost()
		assertEquals(4000, c.totalReservationCost());
		
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
