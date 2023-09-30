package com.naishaairlines.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;

import com.naishaairlines.dto.CommonPaginationDTO;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Booking;

public interface BookingServices {
	
	Booking registerBooking(Booking booking, Authentication authentication) throws NoDataFoundException;
	Booking updateBooking(Booking booking) throws NoDataFoundException;
	Booking cancelBooking(Integer BookingId) throws NoDataFoundException;
	Booking viewBookingById(Integer bookingId) throws NoDataFoundException;
	Booking viewBookingByPnr(String pnrNumber) throws NoDataFoundException;
	List<Booking> viewBookingsByDate(LocalDate bookinDate) throws NoDataFoundException;
	List<Booking> viewAllBookingsOfFlight(Integer flightId) throws NoDataFoundException;
	CommonPaginationDTO<Booking> viewAllBookingsOfFlight(int pageNumber, int pageSize, String sortByColumn, String sortDirection, Integer flightId) throws NoDataFoundException;
	List<Booking> viewAllBookingsOfPassenger(Integer passengerId) throws NoDataFoundException;
	CommonPaginationDTO<Booking> viewAllBookingsOfPassenger(int pageNumber, int pageSize, String sortByColumn, String sortDirection, Integer passengerId) throws NoDataFoundException;
	List<Booking> viewAllBookings() throws NoDataFoundException;
	CommonPaginationDTO<Booking> viewAllBookings(int pageNumber, int pageSize, String sortByColumn, String sortDirection) throws NoDataFoundException;
	
}
