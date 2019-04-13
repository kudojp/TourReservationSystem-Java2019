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
 * Test class for EducationTrip class.
 * @author dkudo
 *
 */
public class LandTourTest {
	
	/**
	 * Sets up the Reservation class
	 * Resets confirmation code.
	 */
	@Before
    public void setUp() {
      Reservation.resetCodeGenerator();
    }

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#Tour(java.lang.String, java.time.LocalDate, int, int, int)}.
	 */
	@Test
	public void testLandTour() {
		Tour t = null;
		try {
			t = new LandTour("name", LocalDate.of(2019, 11, 11), 7, 500, 50);
		} catch (IllegalArgumentException e) {
			fail();			
		}
		assertEquals("LT-name", t.getName());
		assertEquals(LocalDate.of(2019, 11, 11), t.getStartDate());
		assertEquals(LocalDate.of(2019, 11, 17), t.getEndDate());
		assertEquals(7, t.getDuration());
		assertEquals(500, t.getBasePrice());
		assertEquals(50, t.getCapacity());
		assertEquals(7, t.getDuration());
		
	
		
		// invalid  : name = null;
		try {
			t = new LandTour(null, LocalDate.of(2019, 11, 11) , 7, 500, 50);
			fail();
		} catch (IllegalArgumentException e) {	
			assertEquals(e.getMessage(), "Tour name is invalid.");
		}
		
		// invalid  : name = empty 
		try {
			t = new LandTour("", LocalDate.of(2019, 11, 11), 7, 500, 50);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Tour name is invalid.");
		}
		
		// invalid : date == null
		try {
			t = new LandTour("name", null , 7, 500, 50);
			fail();
		} catch (IllegalArgumentException e) {	
			assertEquals(e.getMessage(), "Tour start date is invalid.");
		}
		
		// invalid : duration is negative or 0
		try {
			t = new LandTour("name", LocalDate.of(2019, 11, 11), -1, 500, 50);
			fail();
		} catch (IllegalArgumentException e) {	
			assertEquals(e.getMessage(), "Tour duration is invalid.");
		}
		
		// invalid : duration is negative or 0
		try {
			t = new LandTour("name", LocalDate.of(2019, 11, 11), 7, -1, 50);
			fail();
		} catch (IllegalArgumentException e) {	
			assertEquals(e.getMessage(), "Tour base price is invalid.");
		}
				
		// invalid : duration is negative or 0
		try {
			t = new LandTour("name", LocalDate.of(2019, 11, 11), 7, 500, -1);
			fail();
		} catch (IllegalArgumentException e) {	
			assertEquals(e.getMessage(), "Tour capacity is invalid.");
		}
		
}

	
	
	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.LandTour#costFor(int)}.
	 */
	@Test
	public void testCostFor() {
		 LandTour et = new LandTour("name", LocalDate.of(2019, 11, 11), 7, 500, 50);
		 assertEquals(625, Math.round(et.costFor(1)));
		 assertEquals(1000, (int)et.costFor(2));
	}

	
	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#compareTo(edu.ncsu.csc216.travel.model.vacation.Tour)}.
	 */
	@Test
	public void testCompareTo() {
		LandTour t1 = new LandTour("name", LocalDate.of(2019, 11, 11), 7, 500, 50);
		
		// name alphabetically earlier
		LandTour t2 = new LandTour("a", LocalDate.of(2019, 11, 11), 7, 500, 50);
		// name alphabetically earlier
		LandTour t3 = new LandTour("z", LocalDate.of(2019, 11, 11), 7, 500, 50);
		
		assertEquals(1, t1.compareTo(t2));
		assertEquals(-1, t1.compareTo(t3));
		
		
		// same name but start date earlier
		LandTour t4 = new LandTour("Name", LocalDate.of(2019, 10, 11), 7, 500, 50);
		// same name but start date later
		LandTour t5 = new LandTour("Name", LocalDate.of(2019, 12, 11), 7, 500, 50);
		
		assertEquals(1, t1.compareTo(t4));
		assertEquals(-1, t1.compareTo(t5));
		
		// same name, same start date, but duration shorter
		LandTour t6 = new LandTour("Name", LocalDate.of(2019, 11, 11), 6, 500, 50);
		// same name, same start date, but duration longer
		LandTour t7 = new LandTour("Name", LocalDate.of(2019, 11, 11), 8, 500, 50);
		
		assertEquals(1, t1.compareTo(t6));
		assertEquals(-1, t1.compareTo(t7));
		
		// same name, same start date, same duration
		LandTour t8 = new LandTour("Name", LocalDate.of(2019, 11, 11), 7, 500, 50);
		
		assertEquals(0, t1.compareTo(t8));
		
	
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#setCapacity(int)}.
	 */
	@Test
	public void testSetCapacity() {
		LandTour et = new LandTour("name", LocalDate.of(2019, 11, 11), 7, 500, 40);
	
		
		// try to set capacity less than or equal to 0
		try {
			et.setCapacity(39);
			fail();
		} catch (CapacityException e) {
			assertEquals(40, et.getCapacity());
		}
		
		// double the capacity.
		try {
			et.setCapacity(80);
			fail();
		} catch (CapacityException e) {
			//pass
		}
		assertEquals(40, et.getCapacity());
		assertTrue(et.isCapacityFixed());
		
	}
	
	/**
	 * Test method for createReservationFor()
	 */
	@Test
	public void testNumberOfClientReservations() {

		LandTour t1 = new LandTour("name1", LocalDate.of(2019, 10, 11), 7, 500, 50);
		
		try {
			t1.createReservationFor(null, 10);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals(0, t1.numberOfClientReservations());
		} catch(CapacityException e) {
			fail();
		}
			
		try {
			t1.createReservationFor(new Client("name1", "contact1"), 0);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals(0, t1.numberOfClientReservations());
		} catch(CapacityException e) {
			fail();
		}	
		

		try {
			t1.createReservationFor(new Client("name1", "contact1"), 10);
		} catch(IllegalArgumentException e) {
			fail();
		} catch(CapacityException e) {
			fail();
		}
		assertEquals(1, t1.numberOfClientReservations());
	}


	/**
	 * Test method for numberOfClientReservaiton(), spacesLeft(), getAllData()
	 */
	@Test
	public void testReservations() {
		LandTour t1 = new LandTour("name1", LocalDate.of(2019, 10, 11), 7, 500, 50);
		
		try {
			t1.createReservationFor(new Client("name1", "contact1"), 10);
			t1.createReservationFor(new Client("name2", "contact2"), 20);
		} catch (CapacityException e) {
			System.out.println(t1.numberOfClientReservations());
			fail(e.getMessage());
		}
		assertEquals(2, t1.numberOfClientReservations());
		assertEquals(20, t1.spacesLeft());
		
		// get the first reservation
		assertEquals("name1", t1.getReservation(0).getClient().getName());
		assertEquals("contact1", t1.getReservation(0).getClient().getContact());
		assertEquals(10, t1.getReservation(0).getNumInParty());
		
		// get the second reservation
		assertEquals("name1", t1.getReservation(0).getClient().getName());
		assertEquals("contact1", t1.getReservation(0).getClient().getContact());
		assertEquals(10, t1.getReservation(0).getNumInParty());
		
		
		// get all data in the first tour.
		Object[] allData = t1.getAllData();
		
		// get the first reservation
		assertEquals("LT-name1", allData[0]);
		assertEquals("10/11/19", allData[1]);
		assertEquals(7, allData[2]);
		assertEquals("$500", allData[3]);
		assertEquals("50", allData[4]);
				
		
	}


	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#summaryInfo()}.
	 */
	@Test
	public void testSummaryInfo() {
		LandTour t1 = new LandTour("name1", LocalDate.of(2009, 9, 9), 7, 500, 50);
		try {
			t1.createReservationFor(new Client("name1", "contact1"), 10);
			t1.createReservationFor(new Client("name2", "contact2"), 20);
		} catch (Exception e) {
			fail();
		}
		
		assertEquals("LT-name1: 09/09/09 7 days", t1.summaryInfo());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		LandTour t1 = new LandTour("name1", LocalDate.of(2019, 10, 11), 7, 500, 50);
		// equal
		LandTour t2 = new LandTour("name1", LocalDate.of(2019, 10, 11), 7, 300, 40);
		// different name
		LandTour t3 = new LandTour("name3", LocalDate.of(2019, 10, 11), 7, 500, 50);
		// different start date
		LandTour t4 = new LandTour("name1", LocalDate.of(2019, 10, 12), 7, 500, 50);
		// different duration
		LandTour t5 = new LandTour("name1", LocalDate.of(2019, 10, 11), 3, 500, 50);
		
		
		assertTrue(t1.equals(t2));
		assertFalse(t1.equals(t3));
		assertFalse(t1.equals(t4));
		assertFalse(t1.equals(t5));
	}


	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#listOfReservations()}.
	 */
	@Test
	public void testListOfReservations() {
		EducationalTrip t1 = new EducationalTrip("name1", LocalDate.of(2019, 10, 11), 7, 500, 50);
		
		Client c1 = new Client("name1", "contact1");
		Client c2 = new Client("name2", "contact2");
		
		try {
			t1.createReservationFor(c1, 10);
			t1.createReservationFor(c2, 20);
			
		} catch (Exception e) {
			fail();
		}
		
		String[] list = t1.listOfReservations();
		assertEquals("000000  10 " + c1.summaryInfo(), list[0]);
		assertEquals("000001  20 " + c2.summaryInfo(), list[1]);
		
	}


	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.vacation.Tour#addOldReservation(edu.ncsu.csc216.travel.model.vacation.Reservation)}.
	 */
	@Test
	public void testAddOldReservation() {
		Tour t1 = new LandTour("name1", LocalDate.of(2019, 10, 11), 7, 500, 50);
		Reservation r1 = new Reservation(t1, new Client("name1", "contact1"), 10);
		Reservation r2 = new Reservation(t1, new Client("name1", "contact1"), 20);
		Reservation r3 = new Reservation(t1, new Client("name1", "contact1"), 30);
		
		try {
			t1.addOldReservation(null);
		} catch (IllegalArgumentException e) {
			//pass
		} catch (CapacityException e) {
			fail();
		}
		
		try {
			t1.addOldReservation(r1);
			t1.addOldReservation(r2);
		} catch (CapacityException e) {
			fail();
		}
		
		try {
			t1.addOldReservation(r3);
			fail();
		} catch (CapacityException e) {
			assertEquals(2, t1.listOfReservations().length);
		}
		
		
	}
	
	/**
	 * Test method for cancselReservation() and spaaceLeft()
	 */
	@Test
	public void testCancelReservation() {
		LandTour t1 = new LandTour("name1", LocalDate.of(2019, 10, 11), 7, 500, 50);
		
		Reservation r1 = null;
		Reservation r2 = null;
		
		try {
			r1 = t1.createReservationFor(new Client("name1", "contact1"), 10);
			assertEquals(40, t1.spacesLeft());
			r2 = t1.createReservationFor(new Client("name2", "contact2"), 20);
			assertEquals(20, t1.spacesLeft());
		} catch (Exception e) {
			fail();
		}
		assertEquals(2, t1.numberOfClientReservations());
		
		t1.cancelReservation(r1);
		assertEquals(r2, t1.getReservation(0));
		
	}

}
