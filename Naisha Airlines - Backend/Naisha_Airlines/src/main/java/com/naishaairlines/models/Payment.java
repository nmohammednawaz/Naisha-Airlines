package com.naishaairlines.models;

import java.time.LocalDate;

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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer paymentId;
    
    @Positive(message = "Amount must be a positive value")
    private double amount;
    
    @NotBlank(message = "Payment Type is Required")
    private String paymentType;
    
    @PastOrPresent(message = "Payment date must be in the past or present")
    private LocalDate paymentDate;
    
    @NotBlank(message = "Payment status is required")
    private String paymentStatus;
    
    @OneToOne
    @JoinColumn(name = "booking_id")
    @JsonIgnore
    private Booking booking;
    
    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    @JsonIgnore
    private Ticket ticket;
    
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    @JsonIgnore
    private Passenger passenger;

	public Payment(@Positive(message = "Amount must be a positive value") double amount,
			@NotBlank(message = "Payment Type is Required") String paymentType,
			@PastOrPresent(message = "Payment date must be in the past or present") LocalDate paymentDate,
			@NotBlank(message = "Payment status is required") String paymentStatus, Booking booking, Ticket ticket,
			Passenger passenger) {
		super();
		this.amount = amount;
		this.paymentType = paymentType;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
		this.booking = booking;
		this.ticket = ticket;
		this.passenger = passenger;
	}

    
}
