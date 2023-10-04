package com.naishaairlines.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naishaairlines.models.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
	
	Optional<Seat> findBySeatNumber(String seatNumber);
	List<Seat> findByClassType(String classType);
}
