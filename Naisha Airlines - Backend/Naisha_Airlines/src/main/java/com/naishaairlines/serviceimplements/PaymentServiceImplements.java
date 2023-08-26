package com.naishaairlines.serviceimplements;

import java.util.List;

import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Payment;
import com.naishaairlines.service.PaymentServices;

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
