package com.naishaairlines.serviceimplements;

import java.util.List;

import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Seat;
import com.naishaairlines.service.SeatServices;

public class SeatServiceImplements implements SeatServices {

	@Override
	public Seat registerSeat(Seat seat) throws DuplicateDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seat viewSeatBySeatNumber(Integer seatNumber) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seat> viewSeatByClasstype(String classType) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seat> viewSeatByFlight(Integer flightId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seat viewSeatByBookingId(Integer bookingId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seat viewSeatByAdditionalPassengerId(Integer addtionalPassengerId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}
