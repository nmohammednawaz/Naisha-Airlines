package com.naishaairlines.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.naishaairlines.dto.CommonDTO;
import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Passenger;

@Service
public class PassengerServiceImplements implements PassengerServices {

	@Override
	public Passenger registerPassenger(Passenger passenger) throws DuplicateDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger updatePassenger(Passenger passenger) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger deActivatePassenger(Integer passengerId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger findPassengerById(Integer passengerId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger findPassengerByEmail(String emailId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger findPassengerByUsername(String username) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Passenger> viewAllPassengers() throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonDTO<Passenger> viewAllPassengers(int pageNumber, int pageSize, String sortByColumn,
			String sortDirection) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
