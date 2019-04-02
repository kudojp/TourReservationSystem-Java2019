/**
 * 
 */
package edu.ncsu.csc216.travel.model.vacation;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

/**
 * Test class for EducationTrip class.
 * @author dkudo
 *
 */
public class EducationalTripTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#Tour(java.lang.String, java.time.LocalDate, int, int, int)}.
	 */
	@Test
	public void testEducationalTrip() {
		Tour t = null;
		try {
			t = new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50);
		} catch (IllegalArgumentException e) {
			fail();			
		}
		assertEquals("ED-name", t.getName());
		assertEquals(LocalDate.of(2019, 11, 11), t.getStartDate());
		assertEquals(LocalDate.of(2019, 11, 18), t.getEndDate());
		assertEquals(7, t.getDuration());
		assertEquals(500, t.getBasePrice());
		assertEquals(50, t.getCapacity());
		assertEquals(7, t.getDuration());
		//assertEquals( t.getReservation());
	
		
		// invalid  : name = null;
		try {
			t = new EducationalTrip(null, LocalDate.of(2019, 11, 11) , 7, 500, 50);
			fail();
		} catch (IllegalArgumentException e) {	
			assertEquals(e.getMessage(), "Tour name is invalid.");
		}
		
		// invalid  : name = empty 
		try {
			t = new EducationalTrip("", LocalDate.of(2019, 11, 11), 7, 500, 50);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Tour name is invalid.");
		}
		
		// invalid : date == null
		try {
			t = new EducationalTrip("name", null , 7, 500, 50);
			fail();
		} catch (IllegalArgumentException e) {	
			assertEquals(e.getMessage(), "Tour start date is invalid.");
		}
		
		// invalid : duration is negative or 0
		try {
			t = new EducationalTrip("name", LocalDate.of(2019, 11, 11), -1, 500, 50);
			fail();
		} catch (IllegalArgumentException e) {	
			assertEquals(e.getMessage(), "Tour duration is invalid.");
		}
		
		// invalid : duration is negative or 0
		try {
			t = new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, -1, 50);
			fail();
		} catch (IllegalArgumentException e) {	
			assertEquals(e.getMessage(), "Tour base price is invalid.");
		}
				
		// invalid : duration is negative or 0
		try {
			t = new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, -1);
			fail();
		} catch (IllegalArgumentException e) {	
			assertEquals(e.getMessage(), "Tour capacity is invalid.");
		}
		
}

	
	
	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.EducationalTrip#costFor(int)}.
	 */
	@Test
	public void testCostFor() {
		 EducationalTrip et = new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50);
		 assertEquals(500, (int)et.costFor(1));
		 assertEquals(1000, (int)et.costFor(2));
	}

	
	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#compareTo(edu.ncsu.csc216.travel.model.vacation.Tour)}.
	 */
	@Test
	public void testCompareTo() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#setCapacity(int)}.
	 */
	@Test
	public void testSetCapacity() {
		EducationalTrip et = new EducationalTrip("name", LocalDate.of(2019, 11, 11), 7, 500, 50);
		Eet.setCapacity(100);
		assertEquals(100, et.getCapacity());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#numberOfClientReservations()}.
	 */
	@Test
	public void testNumberOfClientReservations() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#spacesLeft()}.
	 */
	@Test
	public void testSpacesLeft() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#getStartDate()}.
	 */
	@Test
	public void testGetStartDate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#getEndDate()}.
	 */
	@Test
	public void testGetEndDate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#getDuration()}.
	 */
	@Test
	public void testGetDuration() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#getCapacity()}.
	 */
	@Test
	public void testGetCapacity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#isCapacityFixed()}.
	 */
	@Test
	public void testIsCapacityFixed() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#getBasePrice()}.
	 */
	@Test
	public void testGetBasePrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#getReservation(int)}.
	 */
	@Test
	public void testGetReservation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#fixCapacity()}.
	 */
	@Test
	public void testFixCapacity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#summaryInfo()}.
	 */
	@Test
	public void testSummaryInfo() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#getAllData()}.
	 */
	@Test
	public void testGetAllData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#listOfReservations()}.
	 */
	@Test
	public void testListOfReservations() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#createReservationFor(edu.ncsu.csc216.travel.model.participants.Client, int)}.
	 */
	@Test
	public void testCreateReservationFor() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#addOldReservation(edu.ncsu.csc216.travel.model.vacation.Reservation)}.
	 */
	@Test
	public void testAddOldReservation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#cancelReservation(edu.ncsu.csc216.travel.model.vacation.Reservation)}.
	 */
	@Test
	public void testCancelReservation() {
		fail("Not yet implemented");
	}

}
