package com.naishaairlines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.naishaairlines.dto.LoginRequest;
import com.naishaairlines.models.Admin;
import com.naishaairlines.models.Airport;
import com.naishaairlines.models.Flight;
import com.naishaairlines.models.Passenger;
import com.naishaairlines.service.AdminServices;
import com.naishaairlines.service.AirportServices;
import com.naishaairlines.service.FlightServices;
import com.naishaairlines.service.PassengerServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admins")
public class AdminController {
	
	@Autowired
	private AdminServices adminServices;
	
	@Autowired
	private AirportServices airportServices;
	
	@Autowired
	private FlightServices flightServices;
	
	@Autowired
	private PassengerServices passengerServices;
	
	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@Valid @RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminServices.registerAdmin(admin), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdmin(Authentication authentication){
		return new ResponseEntity<Admin>(adminServices.loginAdmin(authentication), HttpStatus.OK);
	}
	
	@PostMapping("/addAirports")
	public ResponseEntity<Airport> addAirport(@Valid @RequestBody Airport airport){
		return new ResponseEntity<Airport>(airportServices.registerAirport(airport), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateAirports")
	public ResponseEntity<Airport> updateAirport(@Valid @RequestBody Airport airport){
		return new ResponseEntity<Airport>(airportServices.updateAirport(airport), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/airports")
	public ResponseEntity<List<Airport>> viewAllAirports(){
		return new ResponseEntity<List<Airport>>(airportServices.viewAllAirports(), HttpStatus.OK);
	}
	
	@GetMapping("arrivingFlights/{airportId}")
	public ResponseEntity<List<Flight>> viewAllArrivingFlights(@PathVariable Integer airportId){
		return new ResponseEntity<List<Flight>>(airportServices.findAllArrivingFlightsByAirportId(airportId), HttpStatus.OK);
	}
	
	@GetMapping("departingFlights/{airportId}")
	public ResponseEntity<List<Flight>> viewAllDepartingFlights(@PathVariable Integer airportId){
		return new ResponseEntity<List<Flight>>(airportServices.findAllDepartingFlightsByAirportId(airportId), HttpStatus.OK);
	}
	
	@GetMapping("/airportByIds/{airportId}")
	public ResponseEntity<Airport> findAirportById(@PathVariable Integer airportId){
		return new ResponseEntity<Airport>(airportServices.findAirportById(airportId), HttpStatus.OK);
	}
	
	@GetMapping("/airportByNames/{airportName}")
	public ResponseEntity<Airport> findAirportByName(@PathVariable String airportName){
		return new ResponseEntity<Airport>(airportServices.findAirportByName(airportName), HttpStatus.OK);
	}
	
	@GetMapping("/airportByLocations/{airportLocation}")
	public ResponseEntity<Airport> findAirportByLocation(@PathVariable String airportLocation){
		return new ResponseEntity<Airport>(airportServices.findAirportByLocation(airportLocation), HttpStatus.OK);
	}
	
	@PostMapping("addFlights")
	public ResponseEntity<Flight> addFlight(@Valid @RequestBody Flight flight){
		return new ResponseEntity<Flight>(flightServices.registerFlight(flight), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateFlights")
	public ResponseEntity<Flight> updateFlight(@Valid @RequestBody Flight flight){
		return new ResponseEntity<Flight>(flightServices.upateFlight(flight), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/flights")
	public ResponseEntity<List<Flight>> viewAllFlights(){
		return new ResponseEntity<List<Flight>>(flightServices.viewAllFlights(), HttpStatus.OK);
	}
	
	@DeleteMapping("deleteFlights/{flightId}")
	public ResponseEntity<Flight> deleteFlightById(@PathVariable Integer flightId){
		return new ResponseEntity<Flight>(flightServices.deleteFlightById(flightId), HttpStatus.OK);
	}
	
	@GetMapping("/flightByIds/{flightId}")
	public ResponseEntity<Flight> findFlightById(@PathVariable Integer flightId){
		return new ResponseEntity<Flight>(flightServices.findFlightById(flightId), HttpStatus.OK);
	}
    
	@GetMapping("/availableSeats/{flightId}")
	public ResponseEntity<Integer> viewAvailableSeatsByFlightId(@PathVariable Integer flightId){
		return new ResponseEntity<Integer>(flightServices.viewAvailableSeats(flightId), HttpStatus.OK);
	}
	
	@GetMapping("/totalSeats/{flightId}")
	public ResponseEntity<Integer> viewTotalSeatsByFlightId(@PathVariable Integer flightId){
		return new ResponseEntity<Integer>(flightServices.viewTotalSeats(flightId), HttpStatus.OK);
	}
	
	@GetMapping("/passengers")
	public ResponseEntity<List<Passenger>> viewAllPassengers(){
		return new ResponseEntity<List<Passenger>>(passengerServices.viewAllPassengers(), HttpStatus.OK);
	}
	
	@GetMapping("/{passengerId}")
	public ResponseEntity<Passenger> findPassengerById(@PathVariable Integer passengerId){
		return new ResponseEntity<Passenger>(passengerServices.findPassengerById(passengerId), HttpStatus.OK);
	}
	
	@DeleteMapping("/passengers/{passengerId}")
	public ResponseEntity<Passenger> deActivatePassenger(@PathVariable Integer passengerId){
		return new ResponseEntity<Passenger>(passengerServices.deActivatePassenger(passengerId), HttpStatus.OK);
	}
	
	
}
