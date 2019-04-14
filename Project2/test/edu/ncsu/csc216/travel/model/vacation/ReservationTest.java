/**
 * 
 */
package edu.ncsu.csc216.travel.model.vacation;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.travel.model.participants.Client;


/**
 * Test class for Reservation class.
 * @author dkudo
 *
 */
public class ReservationTest {
	
	/**
	 * Sets up the Reservation class
	 * Resets confirmation code.
	 */
	@Before
    public void setUp() {
      Reservation.resetCodeGenerator();
    }

	/**
	 * Test method for construction without code. And then cancel the reservation.
	 */
	@Test
	public void testReservationTourClientInt() {
		
		// valid construction 1
		Reservation valid1 = null;
		try {
			valid1 = new Reservation(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name1", "contact1"), 5);
		} catch (Exception e) {
			fail();
		}
		assertEquals(5, valid1.getNumInParty());
		assertEquals(2500, Math.round(valid1.getCost()));
		assertEquals(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), valid1.getTour());
		assertEquals("name1", valid1.getClient().getName());
		assertEquals("contact1", valid1.getClient().getContact());
		assertEquals("000000", valid1.getConfirmationCode());
		assertEquals("000000   5 ED-name: 11/11/19 7 days", valid1.displayReservationTour());
		assertEquals("000000   5 name1 (contact1)", valid1.displayReservationClient());	
		
		// valid construction 2 (Even though this is over capacity, this wont fail since it is Tour's responsibility to check the capacity problem.)
		Reservation valid2 = null;
		try {
			valid2 = new Reservation(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name2", "contact2"), 100);
		} catch (Exception e) {
			fail();
		}
		assertEquals(100, valid2.getNumInParty());
		assertEquals(50000, Math.round(valid2.getCost()));
		assertEquals(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), valid2.getTour());
		assertEquals("name2", valid2.getClient().getName());
		assertEquals("contact2", valid2.getClient().getContact());
		assertEquals("000001", valid2.getConfirmationCode());
		assertEquals("000001 100 ED-name: 11/11/19 7 days", valid2.displayReservationTour());
		assertEquals("000001 100 name2 (contact2)", valid2.displayReservationClient());	
		
		// Tour is null
		try {
			new Reservation(null, new Client("name3", "contact3"), 5);
			fail();
		} catch (IllegalArgumentException e) {
			//pass
		}
			
		// Client is null
		try {
			new Reservation(new EducationalTrip("name3", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name3", "contact3"), 5);
		} catch (IllegalArgumentException e) {
			//pass
		}
		
		// numInParty is less than 1
		try {
			new Reservation(new EducationalTrip("name3", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name3", "contact3"), 0);
		} catch (IllegalArgumentException e) {
			//pass
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#Reservation(edu.ncsu.csc216.travel.model.vacation.Tour, edu.ncsu.csc216.travel.model.participants.Client, int, int)}.
	 */
	@Test
	public void testReservationTourClientIntInt() {
		// valid construction
		Reservation valid1 = null;
		Reservation valid2 = null;
		Reservation valid3 = null;
		EducationalTrip t1 = new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50);
		
		// reservation from a file 1
		try {
			valid1 = new Reservation(t1, new Client("name1", "contact1"), 5, 5);
		} catch (Exception e) {
			fail();
		} 
		assertEquals("000005", valid1.getConfirmationCode());
		
		// reservation from a file 2
		try {
			valid2 = new Reservation(t1, new Client("name2", "contact2"), 3, 3);
		} catch (Exception e) {
			fail();
		}
		assertEquals("000003", valid2.getConfirmationCode());
		
		// reservation after reading from a file
		try {
			valid3 = new Reservation(new EducationalTrip("name3", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name3", "contact3"), 5);
		} catch (IllegalArgumentException e) {
			//pass
		}
		assertEquals("000006", valid3.getConfirmationCode());
			
		
		// Tour is null
		try {
			new Reservation(null, new Client("name1", "contact1"), 5, 5);
			fail();
		} catch (IllegalArgumentException e) {
			//pass
		}
			
		// Client is null
		try {
			new Reservation(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name1", "contact1"), 5, 5);
		} catch (IllegalArgumentException e) {
			//pass
		}
		
		// numInParty is less than 1
		try {
			new Reservation(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name1", "contact1"), 0, 5);
		} catch (IllegalArgumentException e) {
			//pass
		}
		
		// Confirmation code is less than 0
		try {
			new Reservation(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name1", "contact1"), 5, -1);
		} catch (IllegalArgumentException e) {
			//pass
		}
		
		// Confirmation code is larger than 1000000
		try {
			new Reservation(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name1", "contact1"), 5, 1000000);
		} catch (IllegalArgumentException e) {
			//pass
		}
	}



	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#cancel()}.
	 */
	@Test
	public void testCancel() {
		EducationalTrip t1 = new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50);
		EducationalTrip t2 = new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 40);
		Client c1 = new Client("name1", "contact1");
		Client c2 = new Client("name2", "contact2");
		
		Reservation r1 = new Reservation(t1, c1, 10, 1);
		Reservation r2 = new Reservation(t1, c2, 10, 2);
		Reservation r3 = new Reservation(t2, c1, 10, 3);
		
		
		try {
			t1.addOldReservation(r1);
			t1.addOldReservation(r2);
			t2.addOldReservation(r3);
//			c1.addReservation(r1);
//			c2.addReservation(r2);
//			c1.addReservation(r3);
			
		} catch (CapacityException e) {
			fail();
		}
		
		r1.cancel();
		// check that this reservation is removed t1 
		assertEquals(1, t1.numberOfClientReservations());
		assertEquals(r2, t1.getReservation(0));
		
		// check that this reservation is removed from c1
		assertEquals(1, c1.getNumberOfReservations());
		assertEquals(r3, c1.getReservation(0));
	}

	/**
	 * Test method for hashCode() and equals() methods
	 */
	@Test
	public void testHashAndEqualsObject() {
		EducationalTrip t1 = new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50);
		EducationalTrip t2 = new EducationalTrip("name2", LocalDate.of(2019, 11, 11), 7, 500, 50);
		Reservation r1 = new Reservation(t1, new Client("name1", "contact1"), 10, 1);
		// different tour 
		Reservation r2 = new Reservation(t2, new Client("name1", "contact1"), 10, 1);
		// different client
		Reservation r3 = new Reservation(t1, new Client("name2", "contact1"), 10, 1);
		// different duration
		Reservation r4 = new Reservation(t1, new Client("name1", "contact1"), 11, 1);
		// different confirmation code
		Reservation r5 = new Reservation(t1, new Client("name1", "contact1"), 10, 11);
		
		assertEquals(r1.hashCode(), r1.hashCode());
		assertEquals(r1.hashCode(), r2.hashCode());
		assertEquals(r1.hashCode(), r3.hashCode());
		assertEquals(r1.hashCode(), r4.hashCode());
		assertNotEquals(r1.hashCode(), r5.hashCode());
		
		
		
		assertTrue(r1.equals(r1));
		assertTrue(r1.equals(r2));
		assertTrue(r1.equals(r3));
		assertTrue(r1.equals(r4));
		assertFalse(r1.equals(r5));
		
	}
	

}
