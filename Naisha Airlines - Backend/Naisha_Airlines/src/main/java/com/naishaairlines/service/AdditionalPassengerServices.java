package com.naishaairlines.service;

import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.AdditionalPassenger;

public interface AdditionalPassengerServices {
	
	AdditionalPassenger addNewAdditionalPassenger(AdditionalPassenger additionalPassenger);
	AdditionalPassenger removeAdditionalPassenger(Integer additionalPassengerId) throws NoDataFoundException;
	AdditionalPassenger updateAdditionalPassenger(AdditionalPassenger additionalPassenger) throws NoDataFoundException;
	
}
