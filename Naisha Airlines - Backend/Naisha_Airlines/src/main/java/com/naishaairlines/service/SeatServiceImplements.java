package com.naishaairlines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.AdditionalPassenger;
import com.naishaairlines.models.Booking;
import com.naishaairlines.models.Flight;
import com.naishaairlines.models.Seat;
import com.naishaairlines.repository.SeatRepository;

@Service
public class SeatServiceImplements implements SeatServices {
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private FlightServices flightServices;
	
	@Autowired
	private BookingServices bookingServices;
	
	@Autowired AdditionalPassengerServices additionalPassengerServices;

	@Override
	public Seat registerSeat(Seat seat) throws DuplicateDataException {
		// TODO Auto-generated method stub
		return seatRepository.save(seat);
	}

	@Override
	public Seat viewSeatBySeatId(Integer seatId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return seatRepository.findById(seatId).orElseThrow(() -> new NoDataFoundException("No Seat Found With Id: " + seatId));
	}

	@Override
	public Seat viewSeatBySeatNumber(String seatNumber) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return seatRepository.findBySeatNumber(seatNumber).orElseThrow(() -> new NoDataFoundException("No Seat Found With Number: " + seatNumber));
	}
	
	@Override
	public List<Seat> viewSeatByClasstype(String classType) throws NoDataFoundException {
		// TODO Auto-generated method stub
		List<Seat> seatList = seatRepository.findByClassType(classType);
		if(seatList.isEmpty()) throw new NoDataFoundException("No seats found with class: " + classType);
		return seatList;
	}

	@Override
	public List<Seat> viewSeatByFlight(Integer flightId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Flight flight = flightServices.findFlightById(flightId);
		return flight.getSeats();
	}

	@Override
	public Seat viewSeatByBookingId(Integer bookingId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Booking booking = bookingServices.viewBookingById(bookingId);
		return booking.getSeat();
	}

	@Override
	public Seat viewSeatByAdditionalPassengerId(Integer addtionalPassengerId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		AdditionalPassenger additionalPassenger = additionalPassengerServices.findAdditionalPassengerById(addtionalPassengerId);
		return additionalPassenger.getSeat();
	}



}
