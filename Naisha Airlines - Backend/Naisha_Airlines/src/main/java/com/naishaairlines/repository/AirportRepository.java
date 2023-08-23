package com.naishaairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naishaairlines.models.Airport;

public interface AirportRepository extends JpaRepository<Airport, Integer> {

}
