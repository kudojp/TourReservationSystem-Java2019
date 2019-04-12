/**
 * 
 */
package edu.ncsu.csc216.travel.model.office;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.travel.model.vacation.CapacityException;
import edu.ncsu.csc216.travel.model.vacation.Reservation;

/**
 * @author dkudo
 *
 */
public class TourCoordinatorTest {
	
	/**
	 * Sets up the Reservation class
	 * Resets confirmation code.
	 */
	@Before
    public void setUp() {
      Reservation.resetCodeGenerator();

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
	 * Test method for TourCoordinator's addNewClient(), addNewTour(),
	 * addNewReservation(), addOldReservation() methods.
	 */
	@Test
	public void testAddOldClientsNewClientsToursReservations() {
		
		TourCoordinator tc = TourCoordinator.getInstance();
		
		try {
			tc.addNewClient("contact1", "user1");
			tc.addNewClient("contact2", "user2");
			tc.addNewClient("contact3", "user3");
		} catch (DuplicateClientException e) {
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
		} catch (DuplicateTourException dte) {
			fail();
		} catch (IllegalArgumentException iae) {
			//pass
		}

		
		
		try {			
			tc.addNewTour("Education", "et1", LocalDate.of(2019, 1, 1), 1, 200, 100);
			tc.addNewTour("Education", "et2", LocalDate.of(2019, 1, 1), 2, 200, 100);
			tc.addNewTour("Land Tour", "lt", LocalDate.of(2019, 1, 1), 3, 200, 100);
			tc.addNewTour("River Cruise", "rc1", LocalDate.of(2019, 1, 1), 4, 200, 100);
			tc.addNewTour("River Cruise", "rc2", LocalDate.of(2019, 1, 1), 5, 200, 100);
		} catch (DuplicateTourException e) {
			fail();
		}
		
		//try to add duplicated methods.
		try {
			tc.addNewTour("Education", "et1", LocalDate.of(2019, 1, 1), 1, 200, 100);
		} catch (DuplicateTourException dte) {
			assertEquals("Tour is already registered.", dte.getMessage());
		}
		
		
		try {
			// reservation 000000 client 1 for et1 (60)
			tc.addNewReservation(0, 0, 60);
			// another reservation 000001 client 2 for et1 (60)
			tc.addNewReservation(1, 0, 60);
			
			// reservation 000002 client 2 for et2 (60)
			tc.addNewReservation(1, 1, 60);
			// reservation 000003 client 2 for lt (60)
			tc.addNewReservation(1, 2, 60);
			// reservation 000004 client 3 for rc1 (60)
			tc.addNewReservation(2, 3, 60);
			
		} catch (CapacityException e){
			fail();
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#addNewClient(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddNewClient() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#addNewReservation(int, int, int)}.
	 */
	@Test
	public void testAddNewReservation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.office.TourCoordinator#addOldReservation(edu.ncsu.csc216.travel.model.participants.Client, edu.ncsu.csc216.travel.model.vacation.Tour, int, int)}.
	 */
	@Test
	public void testAddOldReservation() {
		fail("Not yet implemented");
	}

}
