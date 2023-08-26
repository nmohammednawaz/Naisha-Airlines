package com.naishaairlines.serviceimplements;

import java.util.List;

import org.springframework.stereotype.Service;

import com.naishaairlines.dto.CommonDTO;
import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Flight;
import com.naishaairlines.service.FlightServices;

@Service
public class FlightServiceImplements implements FlightServices {

	@Override
	public Flight registerFlight(Flight fligth) throws DuplicateDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flight upateFlight(Flight fight) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flight findFlightById(Integer flightId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flight deleteFlightById(Integer flightId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flight viewFlightByNumber(String flightNumber) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> findFlightByDepartureLocation(String departureLocation) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> findFlightByArrivalLocation(String arrivalLocation) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> viewAllFlights() throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

	@Override
	public Integer viewTotalSeats(Integer flightId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
