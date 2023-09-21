package com.naishaairlines.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.naishaairlines.models.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
	
	boolean existsByEmailId(String email);
    boolean existsByUsername(String username);
    boolean existsByContactNumber(String contactNumber);
	Optional<Passenger> findByUsername(String username);
	Optional<Passenger> findByEmailId(String emailId);
	Optional<Passenger> findByContactNumber(String contactNumber);

}
