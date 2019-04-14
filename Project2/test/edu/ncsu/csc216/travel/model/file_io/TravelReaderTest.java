/**
 * 
 */
package edu.ncsu.csc216.travel.model.file_io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.travel.model.office.TourCoordinator;
import edu.ncsu.csc216.travel.model.vacation.Reservation;

/**
 * Test class for TravelReader class.
 * @author dkudo
 *
 */
public class TravelReaderTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.travel.model.file_io.TravelReader#readTravelData(java.lang.String)}.
	 */
	@Test
	public void testReadTravelData() {
		
		
		
		//valid file
		//try {
			TravelReader.readTravelData("test-files/sample.md");
			TravelWriter.writeTravelData("test-files/sampleReadOut.md");
		//} catch(Exception e) {
		//	fail();
		//}
		
		TourCoordinator.getInstance().flushLists();
		Reservation.resetCodeGenerator();
		//invalid file which has duplicated clients
		try {
			TravelReader.readTravelData("test-files/sampleDuplicateClients.md");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Duplicate Clients in a file.", e.getMessage());
		}
		
		TourCoordinator.getInstance().flushLists();
		Reservation.resetCodeGenerator();
		//invalid file which has duplicated clients
		try {
			TravelReader.readTravelData("test-files/sampleDuplicateTours.md");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Duplicate Tours in a file.", e.getMessage());
		}
	}
	
	

}
