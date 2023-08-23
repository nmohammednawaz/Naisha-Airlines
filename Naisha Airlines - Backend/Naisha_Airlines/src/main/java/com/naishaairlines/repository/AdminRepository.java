package com.naishaairlines.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naishaairlines.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByContactNumber(String contactNumber);
	Optional<Admin> findByUsername(String username);
	Optional<Admin> findByEmailId(String emailId);
	Optional<Admin> findByContactNumber(String contactNumber);
	
}
