/**
 * 
 */
package edu.ncsu.csc216.travel.model.file_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.ncsu.csc216.travel.model.office.TourCoordinator;

/**
 * Travel Writer class which is used to save data into a file.
 * @author dkudo
 */
public class TravelWriter {
	
	/**
	 * Writes the data currently in the TourCoordinator to the given file
	 * @param filename : filename of the file where the data would be written
	 * @throws IllegalArgumentException : when any error occurs
	 */
	public static void writeTravelData(String filename) {
		
		
		// clients from file >  clients added > 
		// # tour > [[ reservations from file > reservations added (from earlier) ]]
		// # tour > [[ reservations from file > reservations added (from earlier) ]]
		// # tour > [[ reservations from file > reservations added (from earlier) ]]	
		
		
		// If the filename entered by the user is blank, just whitespace, or does not end with .md, 
		// an error dialog opens with the message “File not saved.” 
		// The user clicks OK, closing the dialog and aborting the file save operation.
		if (filename == null || filename.trim().length() <= 3 || 
				!filename.substring(filename.length() - 3).equals(".md")){
			throw new IllegalArgumentException("File not saved.");
		}
		
		TourCoordinator.getInstance().setFilters("Any", 0, Integer.MAX_VALUE);
		
		try {
			// construct a filewriter.
			FileWriter fw = new FileWriter(new File(filename));
			
			
			// get all Clients info. 
			String[] allClients = TourCoordinator.getInstance().listClients();
			// write all the Clients info.
			for (String eachClient : allClients) {
				fw.write(eachClient + "\n");
			}
			fw.write("\n");
			
			// get number of all Tours data
			int numTours = TourCoordinator.getInstance().filteredTourData().length;
			// for each Tour
			for (int i = 0 ; i < numTours ; i++ ) {
				Object[] eachTour = TourCoordinator.getInstance().filteredTourData()[i];
				// print (#name:  date  duration   $cost  capacity) of this tour
				fw.write("#" + eachTour[0] + ":  " + eachTour[1] + "  " +
						eachTour[2] + "   " + eachTour[3] + "  " + eachTour[4] + "\n");
				
				// print all the reservations made for that Tour 
				for (String eachStringReservation : TourCoordinator.getInstance().reservationsForATour(i)) {
					fw.write(eachStringReservation + "\n");
				}
			}
			fw.close();
			
		} catch (IOException e) {
			throw new IllegalArgumentException("Error when writing a file.");
		}
	}
		
		

}
