package com.naishaairlines.dto;

import com.naishaairlines.models.Airport;
import com.naishaairlines.models.Flight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightInfo {
	
	private Flight flight;
    private Airport airport;
	
}
