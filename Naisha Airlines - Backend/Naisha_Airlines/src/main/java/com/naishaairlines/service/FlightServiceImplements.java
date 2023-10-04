package com.naishaairlines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naishaairlines.dto.CommonPaginationDTO;
import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Airport;
import com.naishaairlines.models.Flight;
import com.naishaairlines.models.Seat;
import com.naishaairlines.repository.FlightRepository;

@Service
public class FlightServiceImplements implements FlightServices {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private AirportServices airportServices;
	
	@Autowired
	private SeatServices seatServices;
	
	public double calculatePrice(String classType) {

	    double price = 0.0;
	    if (classType.equals("Economy")) {
	        price = 300.0;
	    } else if (classType.equals("Premium Economy")) {
	        price = 750.0;
	    } else if (classType.equals("Business")) {
	        price = 1300.0;
	    } else if (classType.equals("First Class")) {
	        price = 2500.0;
	    }
	    return price;
	}
	
	public void createSeats(Flight flight) {
		
		int numberOfSeats = flight.getTotalSeats();
		
		// Calculate the number of seats for each category
	    int firstClassSeats = (int) (numberOfSeats * 0.05); // 5% for First Class
	    int businessSeats = (int) (numberOfSeats * 0.15); // 15% for Business
	    int premiumEconomySeats = (int) (numberOfSeats * 0.30); // 30% for Premium Economy
	    int economySeats = numberOfSeats - (firstClassSeats + businessSeats + premiumEconomySeats); // Remaining for Economy
	    
	 // Create seats for each category
	    for (int i = 1; i <= firstClassSeats; i++) {
	        Seat seat = new Seat("NAFC" + i, "First Class", calculatePrice("First Class"), false, flight, null, null);
	        Seat registeredSeat = seatServices.registerSeat(seat);
	        flight.getSeats().add(registeredSeat);
	    }

	    for (int i = 1; i <= businessSeats; i++) {
	        Seat seat = new Seat("NABC" + i, "Business", calculatePrice("Business"), false, flight, null, null);
	        Seat registeredSeat = seatServices.registerSeat(seat);
	        flight.getSeats().add(registeredSeat);
	    }

	    for (int i = 1; i <= premiumEconomySeats; i++) {
	        Seat seat = new Seat("NAPC" + i, "Premium Economy", calculatePrice("Premium Economy"), false, flight, null, null);
	        Seat registeredSeat = seatServices.registerSeat(seat);
	        flight.getSeats().add(registeredSeat);
	    }

	    for (int i = 1; i <= economySeats; i++) {
	        Seat seat = new Seat("NAEC" + i, "Economy", calculatePrice("Economy"), false, flight, null, null);
	        Seat registeredSeat = seatServices.registerSeat(seat);
	        flight.getSeats().add(registeredSeat);
	    }
	    
	}

	@Override
	public Flight registerFlight(Flight flight) throws DuplicateDataException {
		
		if(flightRepository.existsByFlightNumber(flight.getFlightNumber())) throw new DuplicateDataException("Flight Already Registered With Number " + flight.getFlightNumber());
		
		Airport arrivalAirport = airportServices.findAirportByLocation(flight.getArrivalAirport().getLocation());
		Airport departureAirport = airportServices.findAirportByLocation(flight.getDepartureAirport().getLocation());
		flight.setArrivalAirport(arrivalAirport);
		flight.setDepartureAirport(departureAirport);
		Flight registeredFlight = flightRepository.save(flight);
		arrivalAirport.getArrivingFlights().add(registeredFlight);
		departureAirport.getDepartingFlights().add(registeredFlight);
		airportServices.updateAirport(departureAirport);
		airportServices.updateAirport(arrivalAirport);
		createSeats(registeredFlight);
		return registeredFlight;
	}

	@Override
	public Flight upateFlight(Flight flight) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Airport arrivalAirport = airportServices.findAirportByLocation(flight.getArrivalAirport().getLocation());
		Airport departureAirport = airportServices.findAirportByLocation(flight.getDepartureAirport().getLocation());
		arrivalAirport.getArrivingFlights().add(flight);
		departureAirport.getDepartingFlights().add(flight);
		flight.setArrivalAirport(arrivalAirport);
		flight.setDepartureAirport(departureAirport);
		airportServices.updateAirport(departureAirport);
		airportServices.updateAirport(arrivalAirport);
		return flightRepository.save(flight);
		
	}

	@Override
	public Flight findFlightById(Integer flightId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return flightRepository.findById(flightId).orElseThrow(() -> new NoDataFoundException("No Flight Found With Id " + flightId));
	}

	@Override
	public Flight deleteFlightById(Integer flightId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Flight flight = findFlightById(flightId);
		flight.setDeleted(true);
		return flightRepository.save(flight);
	}

	@Override
	public Flight viewFlightByNumber(String flightNumber) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return flightRepository.findByFlightNumber(flightNumber).orElseThrow(() -> new NoDataFoundException("No Flight Found With Flight Number " + flightNumber));
	}

	@Override
	public List<Flight> findFlightByDepartureLocation(String departureLocation) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Airport airport = airportServices.findAirportByLocation(departureLocation);
		List<Flight> flights = flightRepository.findByDepartureAirport(airport);
		if(flights.isEmpty()) {
			throw new NoDataFoundException("No Data Found");
		}
		return flights;
	}

	@Override
	public List<Flight> findFlightByArrivalLocation(String arrivalLocation) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Airport airport = airportServices.findAirportByLocation(arrivalLocation);
		List<Flight> flights = flightRepository.findByArrivalAirport(airport);
		if(flights.isEmpty()) {
			throw new NoDataFoundException("No Data Found");
		}
		return flights;
	}

	@Override
	public List<Flight> viewAllFlights() throws NoDataFoundException {
		// TODO Auto-generated method stub
		List<Flight> flights = flightRepository.findAll();
		if(flights.isEmpty()) {
			throw new NoDataFoundException("No Data Found");
		}
		return flights;
	}

	@Override
	public CommonPaginationDTO<Flight> viewAllFlights(int pageNumber, int pageSize, String sortByColumn, String sortDirection)
			throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer viewAvailableSeats(Integer flightId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Flight flight = findFlightById(flightId);
        return flight.getAvailableSeats();
	}

	@Override
	public Integer viewTotalSeats(Integer flightId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Flight flight = findFlightById(flightId);
        return flight.getTotalSeats();
	}
	
}
