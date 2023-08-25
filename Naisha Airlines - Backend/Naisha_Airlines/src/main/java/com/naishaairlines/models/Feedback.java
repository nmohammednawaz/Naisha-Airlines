package com.naishaairlines.models;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Feedback {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer feedbackId;
    
    @OneToOne
    @JoinColumn(name = "booking_id")
    @NotNull(message = "Booking is required")
    private Booking booking;
    
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating cannot be more than 5")
    private int rating;
    
    @Length(max = 500, message = "Comments cannot exceed 500 characters")
    private String comments;

	public Feedback(@NotNull(message = "Booking is required") Booking booking,
			@Min(value = 1, message = "Rating must be at least 1") @Max(value = 5, message = "Rating cannot be more than 5") int rating,
			@Length(max = 500, message = "Comments cannot exceed 500 characters") String comments) {
		super();
		this.booking = booking;
		this.rating = rating;
		this.comments = comments;
	}
    
    
}
