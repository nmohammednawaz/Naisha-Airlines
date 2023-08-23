package com.naishaairlines.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class AdditionalPassenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer additionalPassengerId;
	
    @NotBlank(message = "First name is required")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    private String lastName;
    
    @Min(value = 0, message = "Age must be a non-negative value")
    private int age;
    
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Invalid gender")
    private String gender;
    
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

	public AdditionalPassenger(@NotBlank(message = "First name is required") String firstName,
			@NotBlank(message = "Last name is required") String lastName,
			@Min(value = 0, message = "Age must be a non-negative value") int age,
			@Pattern(regexp = "^(Male|Female|Other)$", message = "Invalid gender") String gender, Booking booking,
			Ticket ticket) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.booking = booking;
		this.ticket = ticket;
	}

	
    
    
	
}
