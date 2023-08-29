package com.naishaairlines.service;


import org.springframework.stereotype.Service;

import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Ticket;

@Service
public class TicketServiceImplements implements TicketServices {

	@Override
	public Ticket registerTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket cancelTicket(Integer ticketId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket viewTicketByTicketId(Integer ticketId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket viewTiketByBookingId(Integer bookingId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket viewTicketByPaymentId(Integer paymentId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
