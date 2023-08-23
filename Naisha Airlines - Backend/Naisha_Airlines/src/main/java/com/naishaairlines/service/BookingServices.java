package com.naishaairlines.service;

import java.util.List;

import com.naishaairlines.dto.CommonDTO;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Booking;

public interface BookingServices {
	
	Booking registerBooking(Booking booking);
	Booking updateBooking(Booking booking) throws NoDataFoundException;
	Booking cancelBooking(Integer BookingId) throws NoDataFoundException;
	Booking viewBookingById(Integer bookingId) throws NoDataFoundException;
	List<Booking> viewAllBookings(Integer flightId) throws NoDataFoundException;
	CommonDTO<Booking> viewAllBookings(int pageNumber, int pageSize, String sortByColumn, String sortDirection) throws NoDataFoundException;
	
	
}
