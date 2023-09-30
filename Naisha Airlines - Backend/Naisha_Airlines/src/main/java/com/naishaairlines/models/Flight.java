package com.naishaairlines.models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.AssertTrue;
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
    @JsonIgnore
    private List<Seat> seats = new ArrayList<>();
    
    @OneToMany(mappedBy = "flight")
    @JsonIgnore
    private List<Booking> bookings = new ArrayList<>();
    
    @NotNull(message = "isDeleted field must not be null")
    private boolean isDeleted;
    
    @AssertTrue(message = "Available seats cannot be greater than total seats")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean isAvailableSeatsValid() {
        return availableSeats <= totalSeats;
    }
 
}
