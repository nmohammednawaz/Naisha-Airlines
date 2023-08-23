package com.naishaairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naishaairlines.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
