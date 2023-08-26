package com.naishaairlines.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
@Data
public class Admin {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer adminId;
	
	
	@NotNull(message = "First name is required")
    private String firstName;
    
    @NotNull(message = "Last name is required")
    private String lastName;
    
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Invalid gender")
    private String gender;
    
    @Email(message = "Invalid email format")
    @NotNull(message = "Email is required")
    @Column(unique = true)
    private String emailId;
    
    @NotNull(message = "Username is required")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    @Column(unique = true)
    private String username;
    
    @NotNull(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
    @NotNull(message = "Contact number is required")
    @Column(unique = true)
    private String contactNumber;
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String role = "ADMIN";
    
    @NotNull(message = "isActive field must not be null")
    private boolean isActive;

	public Admin(@NotNull(message = "First name is required") String firstName,
			@NotNull(message = "Last name is required") String lastName,
			@Pattern(regexp = "^(Male|Female|Other)$", message = "Invalid gender") String gender,
			@Email(message = "Invalid email format") @NotNull(message = "Email is required") String emailId,
			@NotNull(message = "Username is required") @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters") String username,
			@NotNull(message = "Password is required") @Size(min = 8, message = "Password must be at least 8 characters") String password,
			@NotNull(message = "Contact number is required") String contactNumber,
			@NotNull(message = "isActive field must not be null") boolean isActive) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.emailId = emailId;
		this.username = username;
		this.password = password;
		this.contactNumber = contactNumber;
		this.isActive = isActive;
	}
    
}
