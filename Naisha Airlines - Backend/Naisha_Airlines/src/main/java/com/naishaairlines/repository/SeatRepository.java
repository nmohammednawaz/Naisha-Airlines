package com.naishaairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naishaairlines.models.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
