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
		
		
		try {
			FileWriter fw = new FileWriter(new File(filename));
			
			// write Clients info
			for (String str : TourCoordinator.getInstance().listClients()) {
				fw.write(str);
				fw.write("\n");
			}
			
			// write Tour info
			TourCoordinator cd = TourCoordinator.getInstance();
			// set filter to all kinds and all durations to get full data.
			
			
			
			//for (int i = 0 ; i < TourCoordinator.getInstance().listClients().) {
			//	fw.write(str);
			//	fw.write("\n");
			//}
			
			
			
		} catch (IOException e) {
			throw new IllegalArgumentException();
		}
	}
		
		

}
