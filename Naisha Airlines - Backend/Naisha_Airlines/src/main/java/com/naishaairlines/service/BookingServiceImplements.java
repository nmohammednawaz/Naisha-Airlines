package com.naishaairlines.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.naishaairlines.dto.CommonDTO;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Booking;
import com.naishaairlines.models.Flight;
import com.naishaairlines.models.Passenger;
import com.naishaairlines.repository.BookingRepository;

@Service
public class BookingServiceImplements implements BookingServices {
	
	@Autowired
	private PassengerServices passengerServices;
	
	@Autowired
	private FlightServices flightServices;
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Booking registerBooking(Booking booking, Authentication authentication) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Passenger passenger = passengerServices.findPassengerByUsername(authentication.getName());
		Flight flight = flightServices.viewFlightByNumber(booking.getFlight().getFlightNumber());
		
		booking.setPassenger(passenger);
		booking.setFlight(flight);
		
//		passenger.getBookings().add(booking);
//		flight.getBookings().add(booking);
		
//		flightServices.upateFlight(flight);
//		passengerServices.updatePassenger(passenger);
		
		return bookingRepository.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking cancelBooking(Integer BookingId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking viewBookingById(Integer bookingId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking viewBookingByPnr(String pnrNumber) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> viewBookingsByDate(LocalDate bookinDate) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> viewAllBookingsOfFlight(Integer flightId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonDTO<Booking> viewAllBookingsOfFlight(int pageNumber, int pageSize, String sortByColumn,
			String sortDirection, Integer flightId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> viewAllBookingsOfPassenger(Integer passengerId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonDTO<Booking> viewAllBookingsOfPassenger(int pageNumber, int pageSize, String sortByColumn,
			String sortDirection, Integer passengerId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> viewAllBookings() throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonDTO<Booking> viewAllBookings(int pageNumber, int pageSize, String sortByColumn, String sortDirection)
			throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
