package com.naishaairlines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naishaairlines.configurations.PasswordEncoderConfiguration;
import com.naishaairlines.dto.CommonDTO;
import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Passenger;
import com.naishaairlines.repository.PassengerRepository;

@Service
public class PassengerServiceImplements implements PassengerServices {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private PasswordEncoderConfiguration passwordEncoderConfiguration;
	
	private void checkDuplicate(String emailId, String username, String contactNumber) throws DuplicateDataException {
		if(passengerRepository.existsByEmailId(emailId)) {
			throw new DuplicateDataException("Dear User, Email Id Already Registered");
		}
		if(passengerRepository.existsByUsername(username)) {
			throw new DuplicateDataException("Dear User, Username Already Registered");
		}
		if(passengerRepository.existsByContactNumber(contactNumber)) {
			throw new DuplicateDataException("Dear User, Contact Number Already Registered");
		}
	}

	@Override
	public Passenger registerPassenger(Passenger passenger) throws DuplicateDataException {
		
		checkDuplicate(passenger.getEmailId(), passenger.getUsername(), passenger.getContactNumber());
		
		passenger.setPassword(passwordEncoderConfiguration.passwordEncoder().encode(passenger.getPassword()));
		return passengerRepository.save(passenger);
	}
	
	@Override
	public Passenger loginPassenger(Authentication authentication) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Passenger passenger = findPassengerByUsername(authentication.getName());
		if(!passenger.isActive()) {
			throw new NoDataFoundException("Dear User, Your Account is Inactive, Please Contact To Customer Care");
		}
		return passenger;
	}

	@Override
	public Passenger updatePassenger(Passenger passenger) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return passengerRepository.save(passenger);
	}

	@Transactional
	@Override
	public Passenger deActivatePassenger(Integer passengerId) throws NoDataFoundException {
		Passenger passenger = findPassengerById(passengerId);
		if(passenger.isActive()) {
			passenger.setActive(false);
		}else {
			throw new NoDataFoundException("Dear Admin, Passenger is Already DeActivated");
		}
		passengerRepository.save(passenger);
		return passenger;
	}

	@Override
	public Passenger findPassengerById(Integer passengerId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return passengerRepository.findById(passengerId).orElseThrow(() -> new NoDataFoundException("Dear User, No Passenger Found With Id: " + passengerId));
	}

	@Override
	public Passenger findPassengerByEmail(String emailId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return passengerRepository.findByEmailId(emailId).orElseThrow(() -> new NoDataFoundException("Dear User, No Passenger Found With Email Id: " + emailId));
	}

	@Override
	public Passenger findPassengerByUsername(String username) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return passengerRepository.findByUsername(username).orElseThrow(() -> new NoDataFoundException("Dear User, No Passenger Found With Username: " + username));
	}

	@Override
	public List<Passenger> viewAllPassengers() throws NoDataFoundException {
		// TODO Auto-generated method stub
		List<Passenger> passengersList = passengerRepository.findAll();
		
		if(passengersList.isEmpty()) {
			throw new NoDataFoundException("No Passengers Found");
		}
		
		return passengersList;
	}

	@Override
	public CommonDTO<Passenger> viewAllPassengers(int pageNumber, int pageSize, String sortByColumn,
			String sortDirection) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
