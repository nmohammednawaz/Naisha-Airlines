package com.naishaairlines.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naishaairlines.models.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	boolean existsByFlightNumber(String flightNumber);
	Optional<Flight> findByFlightNumber(String flightNumber);
	List<Flight> findByDepartureAirport(String departureAirport);
	List<Flight> findByArrivalAirport(String arrivalAirport);

}
