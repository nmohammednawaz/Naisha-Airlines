package com.naishaairlines.serviceimplements;

import java.util.List;

import com.naishaairlines.dto.CommonDTO;
import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Passenger;
import com.naishaairlines.service.PassengerServices;

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
