package com.naishaairlines.service;

import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Feedback;

public interface FeedbackServices {
	
	Feedback registerFeedback(Feedback feedback);
	Feedback updateFeedback(Feedback feedback) throws NoDataFoundException;
	Feedback viewFeedbackByBookingId(Integer bookingId) throws NoDataFoundException;
	Feedback viewFeedbackById(Integer feedbackId) throws NoDataFoundException;
}
