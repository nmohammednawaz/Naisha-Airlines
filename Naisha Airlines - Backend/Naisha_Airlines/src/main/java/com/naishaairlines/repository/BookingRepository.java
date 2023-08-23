package com.naishaairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naishaairlines.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
