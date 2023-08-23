package com.naishaairlines.service;

import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Payment;

public interface PaymentServices {

	Payment registerPayment(Payment payment);
	Payment updatePayment(Payment payment) throws NoDataFoundException;
	Payment viewPaymentById(Integer paymentId) throws NoDataFoundException;
	
}
