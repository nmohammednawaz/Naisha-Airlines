package com.naishaairlines.service;

import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Feedback;

public interface FeedbackServices {
	
	Feedback registerFeedback(Feedback feedback);
	Feedback updateFeedback(Feedback feedback) throws NoDataFoundException;
	
}
