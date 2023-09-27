package com.naishaairlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naishaairlines.models.Booking;
import com.naishaairlines.models.Passenger;
import com.naishaairlines.service.BookingServices;
import com.naishaairlines.service.PassengerServices;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
	
	@Autowired
	private PassengerServices passengerServices;
	
	@Autowired
	private BookingServices bookingServices;
	
	@PostMapping("/register")
	public ResponseEntity<Passenger> registerPassenger(@RequestBody Passenger passenger){
		return new ResponseEntity<Passenger>(passengerServices.registerPassenger(passenger), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Passenger> loginAdmin(Authentication authentication){
		return new ResponseEntity<Passenger>(passengerServices.loginPassenger(authentication), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Passenger> updatePassenger(@RequestBody Passenger passenger){
		return new ResponseEntity<Passenger>(passengerServices.updatePassenger(passenger), HttpStatus.OK);
	}
	
	@PostMapping("/bookTickets")
	public ResponseEntity<Booking> bookTicket(@RequestBody Booking booking, Authentication authentication){
		return new ResponseEntity<Booking>(bookingServices.registerBooking(booking, authentication), HttpStatus.ACCEPTED);
	}
} 
