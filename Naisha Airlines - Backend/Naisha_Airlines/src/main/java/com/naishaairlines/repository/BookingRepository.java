package com.naishaairlines.repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naishaairlines.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	Optional<Booking> findByPnrNumber(String pnrNumber);
	List<Booking> findByBookingDate(LocalDate bookingDate);
	
}
