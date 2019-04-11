/**
 * 
 */
package edu.ncsu.csc216.travel.model.file_io;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.travel.model.office.DuplicateClientException;
import edu.ncsu.csc216.travel.model.office.DuplicateTourException;
import edu.ncsu.csc216.travel.model.office.TourCoordinator;
import edu.ncsu.csc216.travel.model.vacation.Reservation;

/**
 * Test class for TravelWriter class.
 * @author dkudo
 *
 */
public class TravelWriterTest {
	
	
	/**
	 * Sets up the Reservation class
	 * Resets confirmation code.
	 */
	@Before
    public void setUp() {
      Reservation.resetCodeGenerator();
    }
	


	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.file_io.TravelWriter#writeTravelData(java.lang.String)}.
	 */
	@Test
	public void testWriteTravelData() {
		
		TourCoordinator tc = TourCoordinator.getInstance();
		
		
		
		// check the filename validity
		
		
		try {
			tc.addNewClient("contact1", "user1");
			tc.addNewClient("contact2", "user2");
			tc.addNewClient("contact3", "user3");
			tc.addNewClient("contact4", "user4");
		} catch (DuplicateClientException e) {
			fail();
		}
		
		
		try {
			tc.addNewTour("Education", "et1", LocalDate.of(2019, 1, 1), 7, 200, 100);
			tc.addNewTour("Education", "et2", LocalDate.of(2019, 1, 1), 7, 200, 100);
			tc.addNewTour("Land Tour", "lt", LocalDate.of(2019, 1, 1), 7, 200, 100);
			tc.addNewTour("River Cruise", "rc", LocalDate.of(2019, 1, 1), 7, 200, 100);
		} catch (DuplicateTourException e) {
			fail();
		}
		
		
		
		TravelWriter.writeTravelData("test-files/writingTest.md");
		
	}


}
