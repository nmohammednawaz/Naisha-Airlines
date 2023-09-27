package com.naishaairlines.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.naishaairlines.dto.FlightInfo;
import com.naishaairlines.models.Airport;
import com.naishaairlines.models.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	boolean existsByFlightNumber(String flightNumber);
	Optional<Flight> findByFlightNumber(String flightNumber);
	List<Flight> findByDepartureAirport(Airport departureAirport);
	List<Flight> findByArrivalAirport(Airport arrivalAirport);
	
    @Query("SELECT new com.naishaairlines.dto.FlightInfo(f, a) FROM Flight f JOIN f.arrivalAirport a WHERE a.airportId = :airportId")
    List<FlightInfo> findAllArrivingFlightsByAirportId(@Param("airportId") Integer airportId);

    @Query("SELECT new com.naishaairlines.dto.FlightInfo(f, a) FROM Flight f JOIN f.departureAirport a WHERE a.airportId = :airportId")
    List<FlightInfo> findAllDepartingFlightsByAirportId(@Param("airportId") Integer airportId);

}
