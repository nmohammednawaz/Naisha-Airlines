package com.naishaairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naishaairlines.models.AdditionalPassenger;

public interface AdditionalPassengerRepository extends JpaRepository<AdditionalPassenger, Integer> {

}
