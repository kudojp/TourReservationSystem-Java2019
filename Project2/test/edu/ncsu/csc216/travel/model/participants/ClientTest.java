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
	 * Test method for cancelReservation()
	 */
	@Test
	public void testCancelReservation() {
		Client c = new Client("a", "123");
		Tour et  = new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50);
		Reservation r1 = new Reservation(et, c, 3);
		Reservation r2 = new Reservation(et, c, 4);
		Reservation r3 = new Reservation(et, c, 5);
		
		c.addReservation(r1);
		c.addReservation(r2);
		c.addReservation(r3);
		
		c.cancelReservation(r2);
		assertEquals(r1, c.getReservation(0));
		assertEquals(r3, c.getReservation(1));
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


	/**
	 * Test method for hashCode() and Equals()
	 */
	@Test
	public void testEquals() {
		Client c1 = new Client("client1", "contact1");
		// equal
		Client c2 = new Client("client1", "contact1");
		// different client name
		Client c3 = new Client("client2", "contact1");
		// different contact name
		Client c4 = new Client("client1", "contact2");
		//completely different
		Client c5 = new Client("client2", "contact2");
		
		// test hashCode()
		assertEquals(c1.hashCode(), c2.hashCode());
		assertNotEquals(c1.hashCode(), c3.hashCode());
		assertNotEquals(c1.hashCode(), c4.hashCode());
		assertNotEquals(c1.hashCode(), c5.hashCode());
		
		
		// test equals()
		assertTrue(c1.equals(c2));
		assertFalse(c1.equals(c3));
		assertFalse(c1.equals(c4));
		assertFalse(c1.equals(c5));
	}
	
	
}
