package com.naishaairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naishaairlines.models.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
