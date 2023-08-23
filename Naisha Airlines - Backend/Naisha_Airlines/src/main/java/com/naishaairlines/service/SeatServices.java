package com.naishaairlines.service;

import java.util.List;

import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Seat;

public interface SeatServices {
	
	Seat registerSeat(Seat seat) throws DuplicateDataException;
	Seat viewSeatBySeatNumber(Integer seatNumber) throws NoDataFoundException;
	List<Seat> viewSeatByClasstype(String classType) throws NoDataFoundException;
	
	
}
