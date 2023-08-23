package com.naishaairlines.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Ticket {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    
    @NotBlank(message = "Ticket number is required")
    private String ticketNumber;
    
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    @NotNull(message = "Passenger is required")
    private Passenger passenger;
    
    @ManyToOne
    @JoinColumn(name = "flight_id")
    @NotNull(message = "Flight is required")
    private Flight flight;
    
    @ManyToOne
    @JoinColumn(name = "seat_number")
    @NotNull(message = "Seat is required")
    private Seat seat;
    
    @OneToOne
    @NotBlank(message = "Booking Id is required")
    @JoinColumn(name = "booking_id")
    private Booking booking;
    
    @PastOrPresent(message = "Booking date must be in the past or present")
    private LocalDate bookingDate;
    
    @OneToMany(mappedBy = "ticket")
    @JsonIgnore
    private List<AdditionalPassenger> additionalPassengers;

	public Ticket(@NotBlank(message = "Ticket number is required") String ticketNumber,
			@NotNull(message = "Passenger is required") Passenger passenger,
			@NotNull(message = "Flight is required") Flight flight, @NotNull(message = "Seat is required") Seat seat,
			@NotBlank(message = "Booking Id is required") Booking booking,
			@PastOrPresent(message = "Booking date must be in the past or present") LocalDate bookingDate,
			List<AdditionalPassenger> additionalPassengers) {
		super();
		this.ticketNumber = ticketNumber;
		this.passenger = passenger;
		this.flight = flight;
		this.seat = seat;
		this.booking = booking;
		this.bookingDate = bookingDate;
		this.additionalPassengers = additionalPassengers;
	} 
    
    
    
}
