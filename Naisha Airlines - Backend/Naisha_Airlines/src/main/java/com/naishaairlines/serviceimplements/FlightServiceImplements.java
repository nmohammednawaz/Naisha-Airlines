package com.naishaairlines.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naishaairlines.dto.CommonDTO;
import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Flight;
import com.naishaairlines.repository.FlightRepository;
import com.naishaairlines.service.FlightServices;

@Service
public class FlightServiceImplements implements FlightServices {
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public Flight registerFlight(Flight flight) throws DuplicateDataException {
		
		if(flightRepository.existsByFlightNumber(flight.getFlightNumber())) throw new DuplicateDataException("Flight Already Registered With Number " + flight.getFlightNumber());
		
		return flightRepository.save(flight);
	}

	@Override
	public Flight upateFlight(Flight flight) throws NoDataFoundException {
		// TODO Auto-generated method stub
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
		List<Flight> flights = flightRepository.findByDepartureAirport(departureLocation);
		if(flights.isEmpty()) {
			throw new NoDataFoundException("No Data Found");
		}
		return flights;
	}

	@Override
	public List<Flight> findFlightByArrivalLocation(String arrivalLocation) throws NoDataFoundException {
		// TODO Auto-generated method stub
		List<Flight> flights = flightRepository.findByArrivalAirport(arrivalLocation);
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
	public CommonDTO<Flight> viewAllFlights(int pageNumber, int pageSize, String sortByColumn, String sortDirection)
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
