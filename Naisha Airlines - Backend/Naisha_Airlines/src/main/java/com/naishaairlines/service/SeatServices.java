package com.naishaairlines.service;

import java.util.List;

import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Seat;

public interface SeatServices {
	
	Seat registerSeat(Seat seat) throws DuplicateDataException;
	Seat viewSeatBySeatNumber(Integer seatNumber) throws NoDataFoundException;
	List<Seat> viewSeatByClasstype(String classType) throws NoDataFoundException;
	List<Seat> viewSeatByFlight(Integer flightId) throws NoDataFoundException;
	Seat viewSeatByBookingId(Integer bookingId) throws NoDataFoundException;
	Seat viewSeatByAdditionalPassengerId(Integer addtionalPassengerId) throws NoDataFoundException;
	
}
