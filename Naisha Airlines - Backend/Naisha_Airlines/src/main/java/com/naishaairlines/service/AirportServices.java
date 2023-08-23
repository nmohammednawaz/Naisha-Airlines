package com.naishaairlines.service;

import java.util.List;

import com.naishaairlines.dto.CommonDTO;
import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Airport;

public interface AirportServices {
	
	Airport registerAirport(Airport airport) throws DuplicateDataException;
	Airport updateAirport(Airport airport) throws NoDataFoundException;
	Airport findAirportById(Integer airportId) throws NoDataFoundException;
	List<Airport> viewAllAirports() throws NoDataFoundException;
	CommonDTO<Airport> viewAllAirports(int pageNumber, int pageSize, String sortByColumn, String sortDirection) throws NoDataFoundException;
	Airport findAirportByLocation(String location) throws NoDataFoundException;
}
