/**
 * 
 */
package edu.ncsu.csc216.travel.model.office;

import java.time.LocalDate;
import java.util.Observable;

import edu.ncsu.csc216.travel.list_utils.SimpleArrayList;
import edu.ncsu.csc216.travel.list_utils.SortedLinkedListWithIterator;
import edu.ncsu.csc216.travel.model.participants.Client;
import edu.ncsu.csc216.travel.model.vacation.CapacityException;
import edu.ncsu.csc216.travel.model.vacation.Reservation;
import edu.ncsu.csc216.travel.model.vacation.Tour;
import edu.ncsu.csc216.travel.ui.TravelGUI;

/**
 * TourCoordinator class which provides the glue to coordinate the data for the backend model classes.
 * TourCoordinator follows Singleton, Observer, and Factory Patterns.
 * @author dkudo
 * 
 */
public class TourCoordinator extends Observable implements TravelManager {
	
	/** true whenever the TourCoordinator data has not been saved to a file and false otherwise */
	private boolean dataNotSaved;
	/** List of customers */
	private SimpleArrayList<Client> customer;
	/** List of tours*/
	private SortedLinkedListWithIterator<Tour> tours;
	/** String which represents a kind of Tour for filtering */
	private String kindFilter;
	/** integer which represents the input of min duration for filtering */
	private int durationMinFilter;
	/** integer which represents the inpur of max duration for filtering */
	private int durationMaxFilter;

	/**
	 * Constructs TourCoordinator object.
	 * This is a private constructor and called only in getInstance() method only if this class has not been instantiated.
	 */
	private TourCoordinator() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Returns the only instance of this of this class.
	 * (If it has not been instantiated yet, it would be.)
	 * @return : TourCoordinator object 
	 */
	public static TourCoordinator getInstance() {
		return null;
	}
	
	
	/**
	 * Clears all client and tour data from the customer and tours lists, sets TourCoordinator.dataNotSaved to false, and notifies observers. 
	 */
	public void flushLists() {
		// (Note that the other method that sets TourCoordinator.dataNotSaved to false is TourCoordinator.saveToFile().)
	}
	
	/**
	 * Returns true if the data has not been saved and should be saved
	 * @return : true if data should be saved
	 */
	public boolean dataShouldBeSaved() {
		return false;
	}
	
	/**
	 * TODO
	 * @param travelGUI : TODO
	 */
	public void addObserver(TravelGUI travelGUI) {
		// TODO Auto-generated method stub
		
	}	

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#setFilters(java.lang.String, int, int)
	 */
	@Override
	public void setFilters(String kind, int min, int max) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#cancelReservation(int, int)
	 */
	@Override
	public Reservation cancelReservation(int clientIndex, int reservationIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#cancelTour(int)
	 */
	@Override
	public Tour cancelTour(int filteredTourIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#totalClientCost(int)
	 */
	@Override
	public double totalClientCost(int clientIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#listClients()
	 */
	@Override
	public String[] listClients() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#filteredTourData()
	 */
	@Override
	public Object[][] filteredTourData() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#reservationsForAClient(int)
	 */
	@Override
	public String[] reservationsForAClient(int clientIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#reservationsForATour(int)
	 */
	@Override
	public String[] reservationsForATour(int filteredTourIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#loadFile(java.lang.String)
	 */
	@Override
	public void loadFile(String filename) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#saveFile(java.lang.String)
	 */
	@Override
	public void saveFile(String filename) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#getFilename()
	 */
	@Override
	public String getFilename() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tour addNewTour(String kind, String name, LocalDate startDate, int duration, int basePrice, int capacity)
			throws DuplicateTourException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client addNewClient(String contact, String userName) throws DuplicateClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation addNewReservation(int clientIndex, int filteredTourIndex, int numInParty)
			throws CapacityException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation addOldReservation(Client c, Tour t, int numInParty, int confCode) throws CapacityException {
		// TODO Auto-generated method stub
		return null;
	}

}
