/**
 * 
 */
package edu.ncsu.csc216.travel.model.office;

import java.time.LocalDate;

import edu.ncsu.csc216.travel.list_utils.SimpleArrayList;
import edu.ncsu.csc216.travel.list_utils.SortedLinkedListWithIterator;
import edu.ncsu.csc216.travel.model.participants.Client;
import edu.ncsu.csc216.travel.model.vacation.Reservation;
import edu.ncsu.csc216.travel.model.vacation.Tour;

/**
 * TourCoordinator class which provides the glue to coordinate the data for the backend model classes.
 * TourCoordinator follows Singleton, Observer, and Factory Patterns.
 * @author dkudo
 * 
 */
public class TourCoordinator implements TravelManager {
	
	/** List of customers */
	private SimpleArrayList<Client> customer;
	/** List of tours*/
	private SortedLinkedListWithIterator<Tour> tours;

	/**
	 * Constructs TourCoord
	 */
	public TourCoordinator() {
		// TODO Auto-generated constructor stub
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
