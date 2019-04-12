/**
 * 
 */
package edu.ncsu.csc216.travel.model.office;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.travel.model.participants.Client;
import edu.ncsu.csc216.travel.model.vacation.CapacityException;
import edu.ncsu.csc216.travel.model.vacation.EducationalTrip;
import edu.ncsu.csc216.travel.model.vacation.LandTour;
import edu.ncsu.csc216.travel.model.vacation.Reservation;
import edu.ncsu.csc216.travel.model.vacation.RiverCruise;
import edu.ncsu.csc216.travel.model.vacation.Tour;

/**
 * Test class for TourCoordinator class,
 * @author dkudo
 */
public class TourCoordinatorTest {
	
	/** TourCoordinator instance used in this testing class. */
	public TourCoordinator tc = TourCoordinator.getInstance();
	
	/**
	 * Sets up the Reservation class
	 * Resets confirmation code.
	 */
	@Before
    public void setUp() {
      Reservation.resetCodeGenerator();
      tc.flushLists();
      assertFalse(tc.dataShouldBeSaved());
    }





	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#cancelTour(int)}.
	 */
	@Test
	public void testCancelTour() {
		fail("Not yet implemented");
	}


	/**
	 * Test method setFilters(), filteredTourData()
	 */
	@Test
	public void testFilteres() {
		fail("Not yet implemented");
	}


	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#loadFile(java.lang.String)}.
	 */
	@Test
	public void testLoadFile() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#saveFile(java.lang.String)}.
	 */
	@Test
	public void testSaveFile() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#getFilename()}.
	 */
	@Test
	public void testGetFilename() {
		fail("Not yet implemented");
	}

	/**
	 * Tests addNewClient(), lsitClients()
	 */
	@Test
	public void testAddNewClient() {
		
		// add valid clients
		Client c1 = new Client("user1", "contact1");
		Client c2 = new Client("user2", "contact2");
		Client c3 = new Client("user3", "contact3");
		
		try {
			assertEquals(c1, tc.addNewClient("user1", "contact1"));
			assertEquals(c2, tc.addNewClient("user2", "contact2"));
			assertEquals(c3, tc.addNewClient("user3", "contact3"));
		} catch (DuplicateClientException e) {
			fail();
		}
		
		//test listClients()
		assertEquals(3, tc.listClients().length);
		assertEquals("user1 (contact1)", tc.listClients()[0]);
		assertEquals("user2 (contact2)", tc.listClients()[1]);
		assertEquals("user3 (contact3)", tc.listClients()[2]);
		
		//try to add invalid Client.
		try {
			tc.addNewClient(null, null);
			fail();
		} catch (IllegalArgumentException ioe) {
			//pass
		} catch (DuplicateClientException dce) {
			fail();
		}
		
		// try to add invalid client
		try {
			tc.addNewClient(null, null);
			fail();
		} catch (IllegalArgumentException ioe) {
			//pass
		} catch (DuplicateClientException dce) {
			fail();
		}
		
		// try to add duplicated client
		try {
			tc.addNewClient("user1", "contact1");
			fail();
		} catch (IllegalArgumentException ioe) {
			fail();
		} catch (DuplicateClientException dce) {
			//pass
		}
	}
	
	/**
	 * Tests addNewTous()
	 */
	@Test
	public void testAddNewTour() {
		
		Tour t1 = new EducationalTrip("et1", LocalDate.of(2019, 1, 1), 1, 200, 100);
		Tour t2 = new EducationalTrip("et2", LocalDate.of(2019, 1, 1), 2, 200, 100);
		Tour t3 = new LandTour("lt", LocalDate.of(2019, 1, 1), 3, 200, 100);
		Tour t4 = new RiverCruise("rc1", LocalDate.of(2019, 1, 1), 4, 200, 100);
		Tour t5 = new RiverCruise("rc2", LocalDate.of(2019, 1, 1), 5, 200, 100);
		
		// try to add valid tours.
		try {			
			assertEquals(t1, tc.addNewTour("Education", "et1", LocalDate.of(2019, 1, 1), 1, 200, 100));
			assertEquals(t2, tc.addNewTour("Education", "et2", LocalDate.of(2019, 1, 1), 2, 200, 100));
			assertEquals(t3, tc.addNewTour("Land Tour", "lt", LocalDate.of(2019, 1, 1), 3, 200, 100));
			assertEquals(t4, tc.addNewTour("River Cruise", "rc1", LocalDate.of(2019, 1, 1), 4, 200, 100));
			assertEquals(t5, tc.addNewTour("River Cruise", "rc2", LocalDate.of(2019, 1, 1), 5, 200, 100));
		} catch (DuplicateTourException e) {
			fail();
		}
		
		// try to add invalid kind's Tour 
		try {
			tc.addNewTour(null, "tour", LocalDate.of(2019, 1, 1), 1, 200, 100);
			fail();
		} catch (DuplicateTourException dte) {
			fail();
		} catch (IllegalArgumentException iae) {
			//pass
		}
		
		
		// try to add invalid kind's Tour 
		try {
			tc.addNewTour("No Kind", "tour", LocalDate.of(2019, 1, 1), 1, 200, 100);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("TourCoordinator.addNewTour() received No Kind as the kind.", e.getMessage());
		} catch (DuplicateTourException dte) {
			//pass
		}
		
		//try to add duplicate methods.
		try {
			tc.addNewTour("Education", "et1", LocalDate.of(2019, 1, 1), 1, 200, 100);
		} catch (DuplicateTourException dte) {
			assertEquals("Tour is already registered.", dte.getMessage());
		}
		
		assertTrue(tc.dataShouldBeSaved());
		
	}


	/**
	 * Test method for addNewReservation,addOldReservation(), 
	 * cancelReservation(), cancelTour(), totalClientCost()
	 * 
	 * First 3 clients and 3 tours(et, lt, rc)
	 * Reservations are : 
	 * c1>et, c1>et, c1>et, c2>lt, c2>rc, c3>rc   
	 * 
	 * Then the Reservation(3rd  1>et) and Tour rc are removed.
	 * and the reservations left are : 
	 * c1>et, c1>et, c2>lt, c3 
	 */
	@Test
	public void testAddOldAndNewReservations() {
		
		// add clients
		Client c1 = null;
		Client c2 = null;
		Client c3 = null;
		try {
			c1 = tc.addNewClient("user1", "contact1");
			c2 = tc.addNewClient("user2", "contact2");
			c3 = tc.addNewClient("user3", "contact3");
		} catch (DuplicateClientException e) {
			fail();
		}
		
		// add tours
		Tour et = null;
		Tour lt = null;
		Tour rc = null;
		try {
			et = tc.addNewTour("Education", "et", LocalDate.of(2019, 1, 1), 1, 200, 100);
			lt = tc.addNewTour("Land Tour", "lt", LocalDate.of(2019, 1, 1), 3, 200, 100);
			rc = tc.addNewTour("River Cruise", "rc", LocalDate.of(2019, 1, 1), 4, 200, 100);
		} catch (DuplicateTourException e1) {
			fail();
		}
		
		Reservation res2 = null;
		// add Reservations
		try {
			// add oldReesrvation 000500 client 1 for et(50)  ::: total 10k
			Reservation res1 = tc.addOldReservation(c1, et, 50, 500);
			assertEquals(et, res1.getTour());
			assertEquals(c1, res1.getClient());
			assertEquals("000500", res1.getConfirmationCode());
			
			// add oldReesrvation 000250 client 1 for et(50)   :::total 10k
			res2 = tc.addOldReservation(c1, et, 50, 250);
			assertEquals(et, res2.getTour());
			assertEquals(c1, res2.getClient());
			assertEquals("000250", res2.getConfirmationCode());
			
			// reservation 000000 client 1 for et (50)   :::total 10k
			// check expanding for educational trip
			Reservation res3 = tc.addNewReservation(0, 0, 50);
			assertEquals(et, res3.getTour());
			assertEquals(c1, res3.getClient());
			assertEquals("000501", res3.getConfirmationCode());
			
			// another client 1 for et (100) should throw capacity exception
			try {
				tc.addNewReservation(0, 0, 100);
				fail();
			} catch (CapacityException ce) {
				//pass
			}
			
			// reservation 000502 client 2 for lt (50)
			Reservation res4 = tc.addNewReservation(1, 1, 50);
			assertEquals(lt, res4.getTour());
			assertEquals(c2, res4.getClient());
			//assertEquals("000502", res4.getConfirmationCode());
			
			// another client 2 for lt (100) should throw capacity exception
			try {
				tc.addNewReservation(1, 1, 100);
				fail();
			} catch (CapacityException ce) {
				//pass
			}

			// reservation 000503 client 2 for rc (50)
			Reservation res5 = tc.addNewReservation(1, 2, 50);
			assertEquals(rc, res5.getTour());
			assertEquals(c2, res5.getClient());
			//assertEquals("000503", res5.getConfirmationCode());
			
			// reservation 000504 client 3 for rc (50)
			Reservation res6 = tc.addNewReservation(2, 2, 50);
			assertEquals(rc, res6.getTour());
			assertEquals(c3, res6.getClient());
			//assertEquals("000503", res5.getConfirmationCode());
			
			// another client 3 for rc (100) should throw capacity exception
			try {
				tc.addNewReservation(2, 2, 100);
				fail();
			} catch (CapacityException ce) {
				//pass
			}
			
		} catch (CapacityException e){
			fail();
		}
		
		// cancel the 1st client(c1)'s  2nd reservation 
		// which is oldReesrvation 000250 client 1 for et(50)
		Reservation canceledR = tc.cancelReservation(0, 1);
		assertEquals(res2, canceledR);
		
		// remove the 3rd Tour(rc)
		// ERROR HERE!!!!!!!
		Tour canceledT = tc.cancelTour(2);
		assertEquals(rc, canceledT);
		
		//should throw IAE below
		//assertEquals(0, tc.reservationsForATour(2));
		
		assertEquals(20000, Math.round(tc.totalClientCost(0)));
		assertEquals(10000, Math.round(tc.totalClientCost(1)));
		assertEquals(0, Math.round(tc.totalClientCost(2)));
		
		
		//assert that the reservation is removed from client c1
		assertEquals(2, tc.reservationsForAClient(0).length);
		assertEquals("000500  50 ED-et: 01/01/19 1 days", tc.reservationsForAClient(0)[0]);
		assertEquals("000501  50 ED-et: 01/01/19 1 days", tc.reservationsForAClient(0)[1]);
		
		//assert that the reservation is removed from tour c1
		assertEquals(2, tc.reservationsForATour(0).length);
		assertEquals("000500  50 user1 (contact1)", tc.reservationsForATour(0)[0]);
		assertEquals("000501  50 user1 (contact1)", tc.reservationsForATour(0)[1]);
		
		//assert that there is no River Cruise any more
		tc.setFilters("RC", 0, 10000);
		assertEquals(0, tc.filteredTourData().length);
		
		tc.setFilters("All", 0, 10000);
		//assert that reservation for rc is removed from c2 and c3
		assertEquals(1, tc.reservationsForAClient(1).length);
		assertEquals("000503  50 LT-lt: 01/01/19 3 days", tc.reservationsForAClient(1)[0]);
		assertEquals(0, tc.reservationsForAClient(2).length);
		assertEquals("000503  50 LT-lt: 01/01/19 3 days", tc.reservationsForAClient(2)[0]);
		
		assertTrue(tc.dataShouldBeSaved());
		
	}


}
