package com.naishaairlines.service;

import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Ticket;

public interface TicketServices {

	Ticket registerTicket(Ticket ticket);
	Ticket cancelTicket(Integer ticketId) throws NoDataFoundException;
	Ticket viewTicketByTicketId(Integer ticketId) throws NoDataFoundException;
	
}
