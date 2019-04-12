/**
 * 
 */
package edu.ncsu.csc216.travel.model.office;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.TCKind;

import edu.ncsu.csc216.travel.model.participants.Client;
import edu.ncsu.csc216.travel.model.vacation.CapacityException;
import edu.ncsu.csc216.travel.model.vacation.EducationalTrip;
import edu.ncsu.csc216.travel.model.vacation.LandTour;
import edu.ncsu.csc216.travel.model.vacation.Reservation;
import edu.ncsu.csc216.travel.model.vacation.RiverCruise;
import edu.ncsu.csc216.travel.model.vacation.Tour;

/**
 * @author dkudo
 *
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
    }


	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#flushLists()}.
	 */
	@Test
	public void testFlushLists() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#dataShouldBeSaved()}.
	 */
	@Test
	public void testDataShouldBeSaved() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#addObserver(edu.ncsu.csc216.travel.ui.TravelGUI)}.
	 */
	@Test
	public void testAddObserverTravelGUI() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#setFilters(java.lang.String, int, int)}.
	 */
	@Test
	public void testSetFilters() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#cancelReservation(int, int)}.
	 */
	@Test
	public void testCancelReservation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#cancelTour(int)}.
	 */
	@Test
	public void testCancelTour() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#totalClientCost(int)}.
	 */
	@Test
	public void testTotalClientCost() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#listClients()}.
	 */
	@Test
	public void testListClients() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#filteredTourData()}.
	 */
	@Test
	public void testFilteredTourData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#reservationsForAClient(int)}.
	 */
	@Test
	public void testReservationsForAClient() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#reservationsForATour(int)}.
	 */
	@Test
	public void testReservationsForATour() {
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
	 * Tests addNewClient(),
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
		
	}


	/**
	 * Test method for addNewReservation() and addOldReservation() methods.
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
		
		
		// add Reservations
		try {
			// add oldReesrvation 000500 client 1 for et(50)
			Reservation res1 = tc.addOldReservation(c1, et, 50, 500);
			assertEquals(et, res1.getTour());
			assertEquals(c1, res1.getClient());
			assertEquals("000500", res1.getConfirmationCode());
			
			// add oldReesrvation 000250 client 1 for et(50)
			Reservation res2 = tc.addOldReservation(c1, et, 50, 250);
			assertEquals(et, res2.getTour());
			assertEquals(c1, res2.getClient());
			assertEquals("000250", res2.getConfirmationCode());
			
			// reservation 000000 client 1 for et (50)
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
			
			// reservation 000002 client 3 for rc (50)
			Reservation res5 = tc.addNewReservation(2, 2, 50);
			assertEquals(rc, res5.getTour());
			assertEquals(c3, res5.getClient());
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
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#addOldReservation(edu.ncsu.csc216.travel.model.participants.Client, edu.ncsu.csc216.travel.model.vacation.Tour, int, int)}.
	 */
	@Test
	public void testAddOldReservation() {
		fail("Not yet implemented");
	}

}
