package com.naishaairlines.service;

import java.time.LocalDate;
import java.util.List;

import com.naishaairlines.dto.CommonDTO;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Booking;

public interface BookingServices {
	
	Booking registerBooking(Booking booking);
	Booking updateBooking(Booking booking) throws NoDataFoundException;
	Booking cancelBooking(Integer BookingId) throws NoDataFoundException;
	Booking viewBookingById(Integer bookingId) throws NoDataFoundException;
	Booking viewBookingByPnr(String pnrNumber) throws NoDataFoundException;
	List<Booking> viewBookingsByDate(LocalDate bookinDate) throws NoDataFoundException;
	List<Booking> viewAllBookingsOfFlight(Integer flightId) throws NoDataFoundException;
	CommonDTO<Booking> viewAllBookingsOfFlight(int pageNumber, int pageSize, String sortByColumn, String sortDirection, Integer flightId) throws NoDataFoundException;
	List<Booking> viewAllBookingsOfPassenger(Integer passengerId) throws NoDataFoundException;
	CommonDTO<Booking> viewAllBookingsOfPassenger(int pageNumber, int pageSize, String sortByColumn, String sortDirection, Integer passengerId) throws NoDataFoundException;
	List<Booking> viewAllBookings() throws NoDataFoundException;
	CommonDTO<Booking> viewAllBookings(int pageNumber, int pageSize, String sortByColumn, String sortDirection) throws NoDataFoundException;
	
}
