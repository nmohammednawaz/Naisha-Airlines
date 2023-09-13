package com.naishaairlines.models;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Flight {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer flightId;
    
    @NotBlank(message = "Flight number is required")
    private String flightNumber;
    
    @ManyToOne
    @JoinColumn(name = "departure_airport_code")
    private Airport departureAirport;
    
    @ManyToOne
    @JoinColumn(name = "arrival_airport_code")
    private Airport arrivalAirport;
    
    private LocalTime departureTime;
    
    private LocalTime arrivalTime;
    
    @Min(value = 1, message = "Total seats must be at least 1")
    private int totalSeats;
    
    @Min(value = 0, message = "Available seats cannot be negative")
    private int availableSeats;
    
    @Positive(message = "Fare must be a positive value")
    private double fare;
    
    @OneToMany(mappedBy = "flight")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Seat> seats;
    
    @OneToMany(mappedBy = "flight")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Booking> bookings;
    
    @NotNull(message = "isDeleted field must not be null")
    private boolean isDeleted;
    
    @AssertTrue(message = "Available seats cannot be greater than total seats")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean isAvailableSeatsValid() {
        return availableSeats <= totalSeats;
    }

	public Flight(@NotBlank(message = "Flight number is required") String flightNumber, Airport departureAirport,
			Airport arrivalAirport,
			@FutureOrPresent(message = "Departure time must be in the future or present") LocalTime departureTime,
			@Future(message = "Arrival time must be in the future") LocalTime arrivalTime,
			@Min(value = 1, message = "Total seats must be at least 1") int totalSeats,
			@Min(value = 0, message = "Available seats cannot be negative") int availableSeats,
			@Positive(message = "Fare must be a positive value") double fare, List<Seat> seats, List<Booking> bookings,
			@NotNull(message = "isDeleted field must not be null") boolean isDeleted) {
		super();
		this.flightNumber = flightNumber;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.fare = fare;
		this.seats = seats;
		this.bookings = bookings;
		this.isDeleted = isDeleted;
	}

	
    
 
}
