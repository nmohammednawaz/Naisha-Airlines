package com.naishaairlines.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.naishaairlines.dto.CommonDTO;
import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Passenger;

public interface PassengerServices {
	
	Passenger registerPassenger(Passenger passenger) throws DuplicateDataException;
	Passenger loginPassenger(Authentication authentication) throws NoDataFoundException;
	Passenger updatePassenger(Passenger passenger) throws NoDataFoundException;
	Passenger deActivatePassenger(Integer passengerId) throws NoDataFoundException;
	Passenger findPassengerById(Integer passengerId) throws NoDataFoundException;
	Passenger findPassengerByEmail(String emailId) throws NoDataFoundException;
	Passenger findPassengerByUsername(String username) throws NoDataFoundException;
	List<Passenger> viewAllPassengers() throws NoDataFoundException;
	CommonDTO<Passenger> viewAllPassengers(int pageNumber, int pageSize, String sortByColumn, String sortDirection) throws NoDataFoundException;
	
}
