package com.naishaairlines.service;

import java.util.List;

import com.naishaairlines.dto.CommonDTO;
import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Booking;
import com.naishaairlines.models.Flight;

public interface FlightServices {

	Flight registerFlight(Flight fligth) throws DuplicateDataException;
	Flight upateFlight(Flight fight) throws NoDataFoundException;
	Flight findFlightById(Integer flightId) throws NoDataFoundException;
	Flight deleteFlightById(Integer flightId) throws NoDataFoundException;
	List<Flight> findFlightByLocation(String location) throws NoDataFoundException;
	List<Flight> viewAllFlights() throws NoDataFoundException;
	CommonDTO<Flight> viewAllFlights(int pageNumber, int pageSize, String sortByColumn, String sortDirection) throws NoDataFoundException;
	Integer viewAvailableSeats(Integer flightId) throws NoDataFoundException;
	Integer viewTotalSeats(Integer flightId) throws NoDataFoundException;
	List<Booking> viewAllBookings(Integer flightId) throws NoDataFoundException;
	CommonDTO<Booking> viewAllBookings(int pageNumber, int pageSize, String sortByColumn, String sortDirection) throws NoDataFoundException;
}
