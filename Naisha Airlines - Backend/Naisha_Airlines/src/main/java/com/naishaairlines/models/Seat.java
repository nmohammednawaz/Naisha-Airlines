package com.naishaairlines.models;

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
    @NotBlank(message = "Seat number is required")
    private Integer seatNumber;
    
    @NotBlank(message = "Class type is required")
    private String classType;
    
    @PositiveOrZero(message = "Price must be a positive or zero value")
    private double price;
    
    @ManyToOne
    @JoinColumn(name = "flight_number")
    @NotNull(message = "Flight is required")
    private Flight flight;
    
    @OneToOne(mappedBy = "seat")
    private Booking booking;

	public Seat(@NotBlank(message = "Class type is required") String classType,
			@PositiveOrZero(message = "Price must be a positive or zero value") double price,
			@NotNull(message = "Flight is required") Flight flight, Booking booking) {
		super();
		this.classType = classType;
		this.price = price;
		this.flight = flight;
		this.booking = booking;
	}
    
    
}
