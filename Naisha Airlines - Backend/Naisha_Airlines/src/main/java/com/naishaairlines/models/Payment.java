package com.naishaairlines.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Payment {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    
    @Positive(message = "Amount must be a positive value")
    private double amount;
    
    @PastOrPresent(message = "Payment date must be in the past or present")
    private LocalDate paymentDate;
    
    @NotBlank(message = "Payment status is required")
    private String paymentStatus;
    
    @ManyToOne
    @JoinColumn(name = "booking_id")
    @NotNull(message = "Booking is required")
    private Booking booking;
    
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    @NotNull(message = "Passenger is required")
    private Passenger passenger;

	public Payment(@Positive(message = "Amount must be a positive value") double amount,
			@PastOrPresent(message = "Payment date must be in the past or present") LocalDate paymentDate,
			@NotBlank(message = "Payment status is required") String paymentStatus,
			@NotNull(message = "Booking is required") Booking booking,
			@NotNull(message = "Passenger is required") Passenger passenger) {
		super();
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
		this.booking = booking;
		this.passenger = passenger;
	}
    
    
}
