package com.naishaairlines.serviceimplements;

import org.springframework.stereotype.Service;

import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.AdditionalPassenger;
import com.naishaairlines.service.AdditionalPassengerServices;

@Service
public class AdditionalPassengerServiceImplements implements AdditionalPassengerServices {

	@Override
	public AdditionalPassenger addNewAdditionalPassenger(AdditionalPassenger additionalPassenger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdditionalPassenger removeAdditionalPassenger(Integer additionalPassengerId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdditionalPassenger updateAdditionalPassenger(AdditionalPassenger additionalPassenger)
			throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
