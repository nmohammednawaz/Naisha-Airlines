package com.naishaairlines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.naishaairlines.dto.CommonDTO;
import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Airport;
import com.naishaairlines.repository.AirportRepository;

@Service
public class AirportServiceImplements implements AirportServices {
	
	@Autowired
	private AirportRepository airportRepository;

	@Override
	public Airport registerAirport(Airport airport) throws DuplicateDataException {
		// TODO Auto-generated method stub
		if(airportRepository.existsByAirportCode(airport.getAirportCode())) {
			throw new DuplicateDataException("Airport Already Registered With Code " + airport.getAirportCode());
		}
		if(airportRepository.existsByName(airport.getName())) {
			throw new DuplicateDataException("Airport Already Exists With Name " + airport.getName());
		}
		return airportRepository.save(airport);
	}

	@Override
	public Airport updateAirport(Airport airport) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return airportRepository.save(airport);
	}

	@Override
	public Airport findAirportById(Integer airportId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return airportRepository.findById(airportId).orElseThrow(() -> new NoDataFoundException("No Aiport Found With Id: " + airportId));
	}

	@Override
	public Airport findAirportByName(String name) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return airportRepository.findByName(name).orElseThrow(() -> new NoDataFoundException("No Aiport Found With Name: " + name));
	}

	@Override
	public List<Airport> viewAllAirports() throws NoDataFoundException {
		// TODO Auto-generated method stub
		List<Airport> airportList = airportRepository.findAll();
		if(airportList.isEmpty()) throw new NoDataFoundException("No Data Found");
		return airportList;
	}

	@Override
	public CommonDTO<Airport> viewAllAirports(int pageNumber, int pageSize, String sortByColumn, String sortDirection)
			throws NoDataFoundException {
		
		Sort sort = sortDirection.equalsIgnoreCase("ASC") ? sort = Sort.by(sortByColumn).ascending() : Sort.by(sortByColumn).descending();
		
		Pageable page = PageRequest.of(pageNumber, pageSize, sort);
		
		Page<Airport> airportPage = airportRepository.findAll(page);
		
		List<Airport> airports = airportPage.getContent();
		
		if(airports.isEmpty()) {
			throw new NoDataFoundException("No Data Found");
		}
		
		CommonDTO<Airport> airportPages = new CommonDTO<>();
		airportPages.setList(airports);
		airportPages.setPageNumber(airportPage.getNumber());
		airportPages.setPageSize(airportPage.getSize());
		airportPages.setTotalElements(airportPage.getTotalElements());
		airportPages.setTotalPages(airportPage.getTotalPages());
		airportPages.setLastPage(airportPage.isLast());
		
		return airportPages;
	}

	@Override
	public Airport findAirportByLocation(String location) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return airportRepository.findByLocation(location).orElseThrow(() -> new NoDataFoundException("No Airport Found With Location: " + location));
	}

	
}
