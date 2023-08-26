package com.naishaairlines.service;

import java.util.List;

import com.naishaairlines.dto.CommonDTO;
import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Flight;

public interface FlightServices {

	Flight registerFlight(Flight fligth) throws DuplicateDataException;
	Flight upateFlight(Flight fight) throws NoDataFoundException;
	Flight findFlightById(Integer flightId) throws NoDataFoundException;
	Flight deleteFlightById(Integer flightId) throws NoDataFoundException;
	Flight viewFlightByNumber(String flightNumber)throws NoDataFoundException;
	List<Flight> findFlightByDepartureLocation(String departureLocation) throws NoDataFoundException;
	List<Flight> findFlightByArrivalLocation(String arrivalLocation) throws NoDataFoundException;
	List<Flight> viewAllFlights() throws NoDataFoundException;
	CommonDTO<Flight> viewAllFlights(int pageNumber, int pageSize, String sortByColumn, String sortDirection) throws NoDataFoundException;
	Integer viewAvailableSeats(Integer flightId) throws NoDataFoundException;
	Integer viewTotalSeats(Integer flightId) throws NoDataFoundException;
}
