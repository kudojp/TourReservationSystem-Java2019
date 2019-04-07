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
	
	/* *
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
		assertEquals("5 ED-name: 11/11/19 7 days", valid1.displayReservationTour());
		assertEquals("5 name1 (contact1)", valid1.displayReservationClient());	
		
		// valid construction 2 (Even though this is over capacity, this wont fail since it is Tour's responsibility to check the capacity problem.)
		Reservation valid2 = null;
		try {
			valid2 = new Reservation(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name2", "contact2"), 1000);
		} catch (Exception e) {
			fail();
		}
		assertEquals(1000, valid2.getNumInParty());
		assertEquals(500000, Math.round(valid2.getCost()));
		assertEquals(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), valid2.getTour());
		assertEquals("name2", valid2.getClient().getName());
		assertEquals("contact2", valid2.getClient().getContact());
		assertEquals("000001", valid2.getConfirmationCode());
		assertEquals("1000 ED-name: 11/11/19 7 days", valid2.displayReservationTour());
		assertEquals("1000 name2 (contact2)", valid2.displayReservationClient());	
		
		// Tour is null
		try {
			Reservation r1 = new Reservation(null, new Client("name3", "contact3"), 5);
			fail();
		} catch (IllegalArgumentException e) {
			//pass
		}
			
		// Client is null
		try {
			Reservation r2 = new Reservation(new EducationalTrip("name3", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name3", "contact3"), 5);
		} catch (IllegalArgumentException e) {
			//pass
		}
		
		// numInParty is less than 1
		try {
			Reservation r3 = new Reservation(new EducationalTrip("name3", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name3", "contact3"), 0);
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
			Reservation r1 = new Reservation(null, new Client("name1", "contact1"), 5, 5);
			fail();
		} catch (IllegalArgumentException e) {
			//pass
		}
			
		// Client is null
		try {
			Reservation r2 = new Reservation(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name1", "contact1"), 5, 5);
		} catch (IllegalArgumentException e) {
			//pass
		}
		
		// numInParty is less than 1
		try {
			Reservation r3 = new Reservation(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name1", "contact1"), 0, 5);
		} catch (IllegalArgumentException e) {
			//pass
		}
		
		// Confirmation code is less than 0
		try {
			Reservation r3 = new Reservation(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name1", "contact1"), 5, -1);
		} catch (IllegalArgumentException e) {
			//pass
		}
		
		// Confirmation code is larger than 1000000
		try {
			Reservation r4 = new Reservation(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name1", "contact1"), 5, 1000000);
		} catch (IllegalArgumentException e) {
			//pass
		}
	}



	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#cancel()}.
	 */
	@Test
	public void testCancel() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}
	
	
	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}


}
