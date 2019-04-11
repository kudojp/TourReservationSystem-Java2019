/**
 * 
 */
package edu.ncsu.csc216.travel.model.office;

import java.time.LocalDate;
import java.util.Observable;
import edu.ncsu.csc216.travel.list_utils.SimpleArrayList;
import edu.ncsu.csc216.travel.list_utils.SortedLinkedListWithIterator;
import edu.ncsu.csc216.travel.model.file_io.TravelWriter;
import edu.ncsu.csc216.travel.model.participants.Client;
import edu.ncsu.csc216.travel.model.vacation.CapacityException;
import edu.ncsu.csc216.travel.model.vacation.EducationalTrip;
import edu.ncsu.csc216.travel.model.vacation.LandTour;
import edu.ncsu.csc216.travel.model.vacation.Reservation;
import edu.ncsu.csc216.travel.model.vacation.RiverCruise;
import edu.ncsu.csc216.travel.model.vacation.Tour;
import edu.ncsu.csc216.travel.ui.TravelGUI;

/**
 * TourCoordinator class which provides the glue to coordinate the data for the backend model classes.
 * TourCoordinator follows Singleton, Observer, and Factory Patterns.
 * @author dkudo
 * 
 */
public class TourCoordinator extends Observable implements TravelManager {
	
	private static TourCoordinator instance;
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
	
	/** list of filtered Tours in the current setting */
	SimpleArrayList<Tour> filteredTours;

	/**
	 * Constructs TourCoordinator object.
	 * This is a private constructor and called only in getInstance() method 
	 * only if this class has not been instantiated.
	 */
	private TourCoordinator() {
		this.dataNotSaved = true;
		this.customer = new SimpleArrayList<Client>();
		this.tours = new SortedLinkedListWithIterator<Tour>();
		this.kindFilter = "Any";
		this.durationMaxFilter = Integer.MAX_VALUE;
		this.durationMinFilter = 0;
		this.setFilters(this.kindFilter, this.durationMinFilter, this.durationMaxFilter);
	}
	
	/**
	 * Returns the only instance of this of this class.
	 * (If it has not been instantiated yet, it would be.)
	 * @return : TourCoordinator object 
	 */
	public static TourCoordinator getInstance() {
		if (instance == null) {
			instance = new TourCoordinator();
		}
		return instance;
	}
	
	
	/**
	 * Clears all client and tour data from the customer and tours lists, sets TourCoordinator.dataNotSaved to false, and notifies observers. 
	 */
	public void flushLists() {
		// (Note that the other method that sets TourCoordinator.dataNotSaved to false is TourCoordinator.saveToFile().)
	
		this.customer = new SimpleArrayList<Client>();
		this.tours = new SortedLinkedListWithIterator<Tour>();
		this.dataNotSaved = false;
		
		super.setChanged();
		super.notifyObservers(this);
	
	
	}
	
	/**
	 * Returns true if the data has not been saved and should be saved
	 * @return : true if data should be saved
	 */
	public boolean dataShouldBeSaved() {
		return this.dataNotSaved;
	}
	
	/**
	 * TODO
	 * @param travelGUI : TODO
	*/
	/**
	public void addObserver(TravelGUI travelGUI) {
		// TODO Auto-generated method stub
		
	}	
	*/

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#setFilters(java.lang.String, int, int)
	 */
	@Override
	public void setFilters(String kind, int min, int max) {
		// note : rbtnLabels = {"Any", "River Cruise", "Land Tour", "Education"}
		
		if (min > max) {
			throw new IllegalArgumentException();
		}
		
		this.kindFilter = kind;
		this.durationMinFilter = min;
		this.durationMaxFilter = max;
		
		// set the field : filteredTours 
		filteredTours = new SimpleArrayList<Tour>();
		
		// for each Tour in the 
		for (int i = 0 ; i < this.tours.size() ; i++) {
			
			// check if the duration is in filtered range (inclusively)
			if (this.durationMinFilter <= this.tours.get(i).getDuration()
					|| this.tours.get(i).getDuration() <= this.durationMaxFilter) {
			
				if (this.kindFilter.equals("Any")) {
					filteredTours.add(this.tours.get(i));
				} else if (this.kindFilter.equals("River Cruise") &&
						this.tours.get(i).getName().substring(0, 2).equals("RC")) {
					filteredTours.add(this.tours.get(i));
				} else if (this.kindFilter.equals("Land Tour") &&
						this.tours.get(i).getName().substring(0, 2).equals("LT")) {
					filteredTours.add(this.tours.get(i));
				} else if (this.kindFilter.equals("Education") &&
						this.tours.get(i).getName().substring(0, 2).equals("EDå")) {
					filteredTours.add(this.tours.get(i));
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#cancelReservation(int, int)
	 */
	@Override
	public Reservation cancelReservation(int clientIndex, int reservationIndex) {
		Client c = this.customer.get(clientIndex);
		Reservation resToBeDeleted = c.getReservation(reservationIndex);
		
		resToBeDeleted.cancel();
		
		this.dataNotSaved = true;
		return resToBeDeleted;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#cancelTour(int)
	 */
	@Override
	public Tour cancelTour(int filteredTourIndex) {
		Tour tourToBeDeleted = this.filteredTours.get(filteredTourIndex);
		
		// remove from filtered Tours
		this.filteredTours.remove(filteredTourIndex);
		
		// remove this Tour.
		for (int i = 0 ; i < this.tours.size() ; i++) {
			if (this.tours.get(i).equals(tourToBeDeleted)) {
				this.tours.remove(i);
			}
		}
		
		// cancel reservations made for this Tour.
		for (int i = 0 ; i < tourToBeDeleted.numberOfClientReservations() ; i++) {
			tourToBeDeleted.getReservation(i).cancel();
		}
		
		this.dataNotSaved = true;
		return tourToBeDeleted;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#totalClientCost(int)
	 */
	@Override
	public double totalClientCost(int clientIndex) {
		
		// Client we are thinking
		Client c = this.customer.get(clientIndex);
		
		// Accumulative cost of Reservations
		double totalCost = 0;
		
		for (int i = 0 ; i < c.getNumberOfReservations() ; i++) {
			totalCost += c.getReservation(i).getCost();
		}
		
		return totalCost;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#listClients()
	 */
	@Override
	public String[] listClients() {
		String[] clients = new String[this.customer.size()];
		
		for (int i = 0 ; i < this.customer.size() ; i++) {
			clients[i] = this.customer.get(i).summaryInfo();
		}
		return clients;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#filteredTourData()
	 */
	@Override
	public Object[][] filteredTourData() {
		// Convert SimpleArrayList to Object[][] to be returned
		Object[][] array2D = new Object[this.filteredTours.size()][5];
		
		for (int i = 0 ; i < this.filteredTours.size() ; i++) {
			array2D[i] = this.filteredTours.get(i).getAllData();
		}
		
		return array2D;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#reservationsForAClient(int)
	 */
	@Override
	public String[] reservationsForAClient(int clientIndex) {
		if (clientIndex < 0 || this.customer.size() <= clientIndex) {
			throw new IllegalArgumentException();
		}
		
		Client c = this.customer.get(clientIndex);
		String[] returnArray = new String[c.getNumberOfReservations()];
		
		for (int i = 0 ; i < c.getNumberOfReservations() ; i++) {
			returnArray[i] = c.getReservation(i).displayReservationTour();
		}
		
		return returnArray;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#reservationsForATour(int)
	 */
	@Override
	public String[] reservationsForATour(int filteredTourIndex) {
		
		Object[][] filteredTours = this.filteredTourData();
		if (filteredTourIndex < 0 || filteredTours.length <= filteredTourIndex) {
			throw new IllegalArgumentException();
		}
		
		Tour t = this.filteredTours.get(filteredTourIndex);
		String[] returnArray = new String[t.numberOfClientReservations()];
		
		for (int i = 0 ; i < t.numberOfClientReservations() ; i++) {
			returnArray[i] = t.getReservation(i).displayReservationClient();
		}
		
		return returnArray;
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
		
		// make sure that change the filter before writing a file.
		// Note for change : This is called inside of TravelWriter.writeTravelData(filename);
		// this.setFilters("Any", 0, Integer.MAX_VALUE);
		
		
		TravelWriter.writeTravelData(filename);
		
		// switch dataNotSaved to false.
		this.dataNotSaved = false;

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
		// rbtnLabels = {"Any", "River Cruise", "Land Tour", "Education"}
		
		Tour newTour = null; 
		
		if (kind.equals("River Cruise")) {
			newTour = new RiverCruise(name, startDate, duration, basePrice, capacity);
		} else if (kind.equals("Land Tour")) {
			newTour = new LandTour(name, startDate, duration, basePrice, capacity);
		} else if (kind.equals("Education")) {
			newTour = new EducationalTrip(name, startDate, duration, basePrice, capacity);
		} else {
			System.out.println("TourCoordinator.addNewTour() had an error.");
			throw new IllegalArgumentException();
		}
		
		// if this is an already existing tour,,,
		if (this.tours.contains(newTour)) {
			throw new DuplicateTourException();
		}
		
		this.tours.add(newTour);
		
		// Needed to update filteredTours
		this.setFilters(this.kindFilter, this.durationMinFilter, this.durationMaxFilter);
		
		this.dataNotSaved = true;
		return newTour;
	}

	@Override
	public Client addNewClient(String contact, String userName) throws DuplicateClientException {
		// Take care that order of contact and userName or opposite
		// when constructing with Client()
		
		Client newClient = new Client(userName, contact);
		
		// if this is an already existing tour,,,
		if (this.customer.contains(newClient)) {
			throw new DuplicateClientException();
		}
		
		this.customer.add(newClient);
		
		this.dataNotSaved = true;
		return newClient;
	}

	@Override
	public Reservation addNewReservation(int clientIndex, int filteredTourIndex, int numInParty)
			throws CapacityException {
		
		Client c = this.customer.get(clientIndex);
		Tour t = this.filteredTours.get(filteredTourIndex);
		
		
		// Here, CapacityException may be thrown when capacity over!
		Reservation newReservation = t.createReservationFor(c, numInParty);
		
		// When you reach here, it means there was enough space in the specified Tour.
		// and the new Reservation has been added to the list hold by that Tour.
		
		
		// I DON'T have to add new Reservation to the reservation list hold by the specified client.
		// It is already done in Tour.createReservationFor(c, numInParty);
		////   c.addReservation(newReservation);
		
		this.dataNotSaved = true;
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.travel.model.office.TravelManager#addOldReservation(edu.ncsu.csc216.travel.model.participants.Client, edu.ncsu.csc216.travel.model.vacation.Tour, int, int)
	 */
	@Override
	public Reservation addOldReservation(Client c, Tour t, int numInParty, int confCode) 
			throws CapacityException {
		
		// Here, CapacityException may be thrown when capacity over!
		Reservation newReservation = t.createReservationFor(c, numInParty);
		
		// When you reach here, it means there was enough space in the specified Tour.
		// and the new Reservation has been added to the list hold by that Tour.
		
		// I have to add new Reservation to the reservation list hold by the specified client.
		c.addReservation(newReservation);
		
		this.dataNotSaved = true;
		return null;
	}
	
	
	

}
