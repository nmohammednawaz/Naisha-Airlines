package com.naishaairlines.models;

import java.time.LocalDate;
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
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Booking {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer bookingId;
    
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    @NotNull(message = "Passenger is required")
    private Passenger passenger;
    
    @OneToMany(mappedBy = "booking")
    @JsonIgnore
    private List<AdditionalPassenger> additionalPassengers;
    
    @ManyToOne
    @JoinColumn(name = "flight_number")
    @NotNull(message = "Flight is required")
    private Flight flight;
    
    @OneToOne
    @JoinColumn(name = "seat_number")
    @NotNull(message = "Seat is required")
    private Seat seat;
    
    @OneToOne(mappedBy = "booking")
    private Ticket ticket;
    
    @OneToOne(mappedBy = "booking")
    private Payment payment;
    
    @OneToOne(mappedBy = "booking")
    @JsonIgnore
    private Feedback feedback;
    
    @NotNull(message = "Booked on date is required")
    private LocalDate bookedOn;
    
    @NotNull(message = "Booking date is required")
    private LocalDate bookingDate;
    
    @NotBlank(message = "Booking status is required")
    private String bookingStatus;

	public Booking(@NotNull(message = "Passenger is required") Passenger passenger,
			List<AdditionalPassenger> additionalPassengers, @NotNull(message = "Flight is required") Flight flight,
			@NotNull(message = "Seat is required") Seat seat, Ticket ticket, Payment payment, Feedback feedback,
			@NotNull(message = "Booked on date is required") LocalDate bookedOn,
			@NotNull(message = "Booking date is required") LocalDate bookingDate,
			@NotBlank(message = "Booking status is required") String bookingStatus) {
		super();
		this.passenger = passenger;
		this.additionalPassengers = additionalPassengers;
		this.flight = flight;
		this.seat = seat;
		this.ticket = ticket;
		this.payment = payment;
		this.feedback = feedback;
		this.bookedOn = bookedOn;
		this.bookingDate = bookingDate;
		this.bookingStatus = bookingStatus;
	}

	
    
 
}
