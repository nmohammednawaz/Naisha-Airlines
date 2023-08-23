package com.naishaairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naishaairlines.models.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
