/**
 * 
 */
package edu.ncsu.csc216.travel.model.vacation;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import edu.ncsu.csc216.travel.model.participants.Client;

/**
 * Test class for Reservation class.
 * @author dkudo
 *
 */
public class ReservationTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#Reservation(edu.ncsu.csc216.travel.model.vacation.Tour, edu.ncsu.csc216.travel.model.participants.Client, int)}.
	 */
	@Test
	public void testReservationTourClientInt() {
		
		// valid construction
		try {
			Reservation validR = new Reservation(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name1", "contact1"), 5);
		} catch (Exception e) {
			fail();
		}
			
		// Tour is null
		try {
			Reservation r1 = new Reservation(null, new Client("name1", "contact1"), 5);
			fail();
		} catch (IllegalArgumentException e) {
			//pass
		}
			
		// Client is null
		try {
			Reservation r2 = new Reservation(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name1", "contact1"), 5);
		} catch (IllegalArgumentException e) {
			//pass
		}
		
		// numInParty is less than 1
		try {
			Reservation r3 = new Reservation(new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50), new Client("name1", "contact1"), 0);
		} catch (IllegalArgumentException e) {
			//pass
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#Reservation(edu.ncsu.csc216.travel.model.vacation.Tour, edu.ncsu.csc216.travel.model.participants.Client, int, int)}.
	 */
	@Test
	public void testReservationTourClientIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#getConfirmationCode()}.
	 */
	@Test
	public void testGetConfirmationCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#getNumInParty()}.
	 */
	@Test
	public void testGetNumInParty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#getCost()}.
	 */
	@Test
	public void testGetCost() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#getTour()}.
	 */
	@Test
	public void testGetTour() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#getClient()}.
	 */
	@Test
	public void testGetClient() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#cancel()}.
	 */
	@Test
	public void testCancel() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#displayReservationTour()}.
	 */
	@Test
	public void testDisplayReservationTour() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#displayReservationClient()}.
	 */
	@Test
	public void testDisplayReservationClient() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Reservation#resetCodeGenerator()}.
	 */
	@Test
	public void testResetCodeGenerator() {
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
