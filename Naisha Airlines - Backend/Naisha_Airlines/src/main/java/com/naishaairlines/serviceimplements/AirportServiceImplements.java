package com.naishaairlines.serviceimplements;

import java.util.List;

import com.naishaairlines.dto.CommonDTO;
import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Airport;
import com.naishaairlines.models.Flight;
import com.naishaairlines.service.AirportServices;

public class AirportServiceImplements implements AirportServices {

	@Override
	public Airport registerAirport(Airport airport) throws DuplicateDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airport updateAirport(Airport airport) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airport findAirportById(Integer airportId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airport findAirportByName(String name) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Airport> viewAllAirports() throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonDTO<Airport> viewAllAirports(int pageNumber, int pageSize, String sortByColumn, String sortDirection)
			throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airport findAirportByLocation(String location) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> viewAllDepartingFlights(Integer airportId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> viewAllArrivingFlights(Integer airportId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
