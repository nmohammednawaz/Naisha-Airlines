package com.naishaairlines.serviceimplements;

import org.springframework.stereotype.Service;

import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Feedback;
import com.naishaairlines.service.FeedbackServices;

@Service
public class FeedbackServiceImplements implements FeedbackServices {

	@Override
	public Feedback registerFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback viewFeedbackByBookingId(Integer bookingId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback viewFeedbackById(Integer feedbackId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}
