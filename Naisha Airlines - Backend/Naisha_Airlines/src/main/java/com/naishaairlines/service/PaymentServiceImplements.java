package com.naishaairlines.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Payment;

@Service
public class PaymentServiceImplements implements PaymentServices {

	@Override
	public Payment registerPayment(Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment updatePayment(Payment payment) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment viewPaymentById(Integer paymentId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> viewPaymentByPassengerId(Integer passengerId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment viewPaymentByBookingId(Integer BookingId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
