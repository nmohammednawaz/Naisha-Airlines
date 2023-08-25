package com.naishaairlines.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotBlank(message = "Seat number is required")
    private Integer seatNumber;
    
    @NotBlank(message = "Class type is required")
    private String classType;
    
    @PositiveOrZero(message = "Price must be a positive or zero value")
    private double price;
    
    private boolean isBooked;
    
    @ManyToOne
    @JoinColumn(name = "flight_number")
    @NotNull(message = "Flight is required")
    private Flight flight;
    
    @OneToOne(mappedBy = "seat", cascade = CascadeType.ALL)
    @JsonIgnore
    private Booking booking;
    
    @OneToOne(mappedBy = "seat", cascade = CascadeType.ALL)
    @JsonIgnore
    private AdditionalPassenger additionalPassengerSeat;

	public Seat(@NotBlank(message = "Class type is required") String classType,
			@PositiveOrZero(message = "Price must be a positive or zero value") double price, boolean isBooked,
			@NotNull(message = "Flight is required") Flight flight, Booking booking,
			AdditionalPassenger additionalPassengerSeat) {
		super();
		this.classType = classType;
		this.price = price;
		this.isBooked = isBooked;
		this.flight = flight;
		this.booking = booking;
		this.additionalPassengerSeat = additionalPassengerSeat;
	}
    
 
}
