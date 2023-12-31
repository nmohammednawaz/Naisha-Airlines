package com.naishaairlines.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Passenger {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer passengerId;
    
	@NotBlank(message = "First name is required")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    private String lastName;
    
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Invalid gender")
    private String gender;
    
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;
    
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String emailId;
    
    @NotBlank(message = "Username is required")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    @Column(unique = true)
    private String username;
    
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
    @NotBlank(message = "Contact number is required")
    @Column(unique = true)
    private String contactNumber;
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String role = "PASSENGER";
    
    @NotNull(message = "isActive field must not be null")
    private boolean isActive;
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings = new ArrayList<>();
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "passenger")
    private List<Payment> payments = new ArrayList<>();
    
    

	public Passenger(@NotBlank(message = "First name is required") String firstName,
			@NotBlank(message = "Last name is required") String lastName,
			@Pattern(regexp = "^(Male|Female|Other)$", message = "Invalid gender") String gender,
			@Past(message = "Date of birth must be in the past") LocalDate dateOfBirth,
			@Email(message = "Invalid email format") @NotBlank(message = "Email is required") String emailId,
			@NotBlank(message = "Username is required") @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters") String username,
			@NotBlank(message = "Password is required") @Size(min = 8, message = "Password must be at least 8 characters") String password,
			@NotBlank(message = "Contact number is required") String contactNumber,
			@NotNull(message = "isActive field must not be null") boolean isActive, List<Booking> bookings,
			List<Payment> payments) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.username = username;
		this.password = password;
		this.contactNumber = contactNumber;
		this.isActive = isActive;
		this.bookings = bookings;
		this.payments = payments;
	}
    
}
