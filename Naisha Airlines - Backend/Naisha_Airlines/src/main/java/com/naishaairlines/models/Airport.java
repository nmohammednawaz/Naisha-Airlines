package com.naishaairlines.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer airportId;
	
	@NotBlank(message = "Airport code is required")
    @Size(max = 3, message = "Airport code cannot exceed 3 characters")
    private String airportCode;
    
    @NotBlank(message = "Name is required")
    private String name;
    
    @NotBlank(message = "Location is required")
    private String location;
    
    @JsonIgnore
    @OneToMany(mappedBy = "departureAirport")
    private List<Flight> departingFlights;
    
    @JsonIgnore
    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flight> arrivingFlights;

	public Airport(
			@NotBlank(message = "Airport code is required") @Size(max = 3, message = "Airport code cannot exceed 3 characters") String airportCode,
			@NotBlank(message = "Name is required") String name,
			@NotBlank(message = "Location is required") String location, List<Flight> departingFlights,
			List<Flight> arrivingFlights) {
		super();
		this.airportCode = airportCode;
		this.name = name;
		this.location = location;
		this.departingFlights = departingFlights;
		this.arrivingFlights = arrivingFlights;
	}

}
