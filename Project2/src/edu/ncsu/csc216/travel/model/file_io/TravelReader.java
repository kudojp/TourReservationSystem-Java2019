/**
 * 
 */
package edu.ncsu.csc216.travel.model.file_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc216.travel.model.office.DuplicateClientException;
import edu.ncsu.csc216.travel.model.office.TourCoordinator;

/**
 * TravelReader class which is used for loading in data from a file.
 * @author dkudo
 */
public class TravelReader {

	/**
	 * Writes the data currently in the TourCoordinator to the given file
	 * @param filename : filename which the data would be loaded in from
	 * @throws IllegalArgumentException : when any error occurs
	 */
	public static void readTravelData(String filename) {
			
				
		try {
			Scanner fileScanner = new Scanner(new File(filename));
			String currentLine;
			
			// clients
			while (fileScanner.hasNextLine()) {
				currentLine = fileScanner.nextLine();
				
				// blank line means the end of Tours.
				if (currentLine.charAt(0) == '#') {
					break;
				}
				
				// if the current line doesn't include "(", this line should nbe skipped
				int index = currentLine.indexOf("(");
				if (index == -1) {
					continue;
				}
				
				// get tokens which represents name and contact
				String customer = currentLine.substring(0, index - 1);
				String contact = currentLine.substring(index + 1, currentLine.length() - 1);
				
				// add a client represented by this line
				try {
					TourCoordinator.getInstance().addNewClient(customer, contact);
				} catch (DuplicateClientException e) {
					// skip the line
				}
			}
			
			// for the line which represents Tour info
			if (currentLine.charAt(0) == '#') {
				// "ED" or "RC" or "LT"
				String tourKind = currentLine.substring(1, 3);
				int index = currentLine.indexOf(':');
				// "Tour name"
				String tourName = currentLine.substring(4, index);
				// the rest of line signifies date, duration, cost, capacity
				Scanner tourLineScanner  = new Scanner(currentLine.substring(index + 1));
				
				String dateToken = tourLineScanner.next();
				int duration = tourLineScanner.nextInt();
				String cost = tourLineScanner.next().substring(1);
				String capacity = tourLineScanner.next();
				
			
			
			// iterate (tour > reservation)
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				
				if (line.trim().length() == 0) {
					break;
				}
				
				
				
			}
			}
			
			
			
			
			
			fileScanner.close();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File not loaded");
		
		}
		
	}
	

}
