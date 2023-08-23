package com.naishaairlines.service;

import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Booking;

public interface BookingServices {
	
	Booking registerBooking(Booking booking);
	Booking updateBooking(Booking booking) throws NoDataFoundException;
	Booking cancelBooking(Integer BookingId) throws NoDataFoundException;
	
	
}
