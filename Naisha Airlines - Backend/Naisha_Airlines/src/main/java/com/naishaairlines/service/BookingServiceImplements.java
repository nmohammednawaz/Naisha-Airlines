package com.naishaairlines.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.naishaairlines.dto.CommonPaginationDTO;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.AdditionalPassenger;
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
		
		passenger.getBookings().add(booking);
		flight.getBookings().add(booking);
		
		int seatCount = booking.getAdditionalPassengers().size()+1;
		flight.setAvailableSeats(flight.getAvailableSeats()-seatCount);
		
		flightServices.upateFlight(flight);
		passengerServices.updatePassenger(passenger);
		
		Booking registeredBooking = bookingRepository.save(booking);
		for(AdditionalPassenger passengers : registeredBooking.getAdditionalPassengers()) {
			passengers.setBooking(registeredBooking);
		}
		
		return bookingRepository.save(registeredBooking);
	}

	@Override
	public Booking updateBooking(Booking booking) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return bookingRepository.save(booking);
	}

	@Override
	public Booking confirmBookingStatus(Integer bookingId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Booking booking = viewBookingById(bookingId);
		booking.setBookingStatus("Confirmed");
		return bookingRepository.save(booking);
	}

	@Override
	public Booking cancelBooking(Integer BookingId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Booking booking = viewBookingById(BookingId);
		booking.setBookingStatus("Cancelled");
		Flight flight = booking.getFlight();
		flight.setAvailableSeats(flight.getAvailableSeats() + booking.getAdditionalPassengers().size() + 1);
		flightServices.upateFlight(flight);
		return bookingRepository.save(booking);
	}

	@Override
	public Booking viewBookingById(Integer bookingId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return bookingRepository.findById(bookingId).orElseThrow(()-> new NoDataFoundException("Dear User, No Booking Found With Id: " + bookingId));
	}

	@Override
	public Booking viewBookingByPnr(String pnrNumber) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return bookingRepository.findByPnrNumber(pnrNumber).orElseThrow(()-> new NoDataFoundException("Dear User, No Booking Found With PNR: " + pnrNumber));
	}

	@Override
	public List<Booking> viewBookingsByDate(LocalDate bookinDate) throws NoDataFoundException {
		// TODO Auto-generated method stub
		List<Booking> bookingList = bookingRepository.findByBookingDate(bookinDate);
		if(bookingList.isEmpty()) {
			throw new NoDataFoundException("No Booking Was Done On " + bookinDate);
		}
		return bookingList;
	}

	@Override
	public List<Booking> viewAllBookingsOfFlight(Integer flightId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Flight flight = flightServices.findFlightById(flightId);
		if(flight.getBookings().isEmpty()) {
			throw new NoDataFoundException("No Booking Found For Flight With Id: " + flightId);
		}
		return flight.getBookings();
	}

	@Override
	public CommonPaginationDTO<Booking> viewAllBookingsOfFlight(int pageNumber, int pageSize, String sortByColumn,
			String sortDirection, Integer flightId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> viewAllBookingsOfPassenger(Integer passengerId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Passenger passenger = passengerServices.findPassengerById(passengerId);
		if(passenger.getBookings().isEmpty()) {
			throw new NoDataFoundException("No Booking Done Yet for Passenger With Id: " + passengerId);
		}
		return passenger.getBookings();
	}

	@Override
	public CommonPaginationDTO<Booking> viewAllBookingsOfPassenger(int pageNumber, int pageSize, String sortByColumn,
			String sortDirection, Integer passengerId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> viewAllBookings() throws NoDataFoundException {
		// TODO Auto-generated method stub
		List<Booking> bookingList = bookingRepository.findAll();
		if(bookingList.isEmpty()) {
			throw new NoDataFoundException("No Booking Found");
		}
		return bookingList;
	}

	@Override
	public CommonPaginationDTO<Booking> viewAllBookings(int pageNumber, int pageSize, String sortByColumn, String sortDirection)
			throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	
}
