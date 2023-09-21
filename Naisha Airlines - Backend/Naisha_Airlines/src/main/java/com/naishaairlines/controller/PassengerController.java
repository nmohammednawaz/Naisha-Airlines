package com.naishaairlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.naishaairlines.models.Passenger;
import com.naishaairlines.service.PassengerServices;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
	
	@Autowired
	private PassengerServices passengerServices;
	
	@PostMapping("/register")
	public ResponseEntity<Passenger> registerPassenger(@RequestBody Passenger passenger){
		return new ResponseEntity<Passenger>(passengerServices.registerPassenger(passenger), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginAdmin(Authentication authentication){
		Passenger passenger = passengerServices.findPassengerByUsername(authentication.getName());
		return new ResponseEntity<String>(passenger.getUsername() + " Sign In SuccessFull..!", HttpStatus.OK);
	}
	
}
