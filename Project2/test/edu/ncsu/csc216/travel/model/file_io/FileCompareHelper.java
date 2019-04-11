/**
 * 
 */
package edu.ncsu.csc216.travel.model.file_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Helper class which holds helper function for comparing 2 files.
 * @author dkudo
 *
 */
public class FileCompareHelper {

	/**
	 * Helper static method which compares 2 files.
	 * @param filename1 filename 
	 * @param filename2 filename of the other file
	 * @return True if the contents of 2 files are identical.
	 */
	public static boolean compareFiles(String filename1, String filename2) {

		try {
			Scanner f1Scanner = new Scanner(new File(filename1));
			Scanner f2Scanner = new Scanner(new File(filename2));
			
			while(f1Scanner.hasNext() && f2Scanner.hasNext()) {
				
				// if the next lines are not identical,,
				if (!f1Scanner.nextLine().equals(f2Scanner.nextLine())){
					f1Scanner.close();
					f2Scanner.close();
					return false;
				}
			}
			
			
			// if only file1 has more lines,,,
			if (f1Scanner.hasNext()) {
				f1Scanner.close();
				f2Scanner.close();
				return false;
			}
			
			// if only file2 has more lines,,,
			if (f2Scanner.hasNext()) {
				f1Scanner.close();
				f2Scanner.close();
				return false;
			}
			
			f1Scanner.close();
			f2Scanner.close();
			
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Error when reading a file.");
		}
		
		return true;
	}

}