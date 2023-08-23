package com.naishaairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naishaairlines.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
