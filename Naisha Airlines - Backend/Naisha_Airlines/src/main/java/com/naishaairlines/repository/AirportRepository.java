package com.naishaairlines.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.naishaairlines.models.Airport;

public interface AirportRepository extends JpaRepository<Airport, Integer> {
	
	boolean existsByAirportCode(String airportCode);
	boolean existsByName(String name);
	Optional<Airport> findByName(String name);
	Optional<Airport> findByLocation(String location);
	
}
