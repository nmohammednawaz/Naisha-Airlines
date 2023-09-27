package com.naishaairlines.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
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
    @JoinColumn(name = "flight_id")
    @NotNull(message = "Flight is required")
    private Flight flight;
    
    @NotNull(message = "PNR is required")
    private String pnrNumber;
    
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonIgnore
    private Passenger passenger;
    
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AdditionalPassenger> additionalPassengers = new ArrayList<>();
    
    @OneToOne
    @JoinColumn(name = "passenger_seat_number")
    @JsonIgnore
    private Seat seat;
    
    @NotNull(message = "Booked on date is required")
    private LocalDate bookedOn;
    
    @NotNull(message = "Booking date is required")
    private LocalDate bookingDate;
    
    @NotBlank(message = "Booking status is required")
    private String bookingStatus;
    
    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonIgnore
    private Ticket ticket;
    
    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonIgnore
    private Payment payment;
    
    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonIgnore
    private Feedback feedback;

	
 
}
