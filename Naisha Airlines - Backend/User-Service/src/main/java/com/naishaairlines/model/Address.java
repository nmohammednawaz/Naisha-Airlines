package com.naishaairlines.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Address {

    @NotBlank(message = "Address is required.")
    @Size(max = 100, message = "Address must not exceed 100 characters.")
    private String address;

    @NotBlank(message = "City is required.")
    @Size(max = 50, message = "City must not exceed 50 characters.")
    private String city;

    @NotBlank(message = "State is required.")
    @Size(max = 50, message = "State must not exceed 50 characters.")
    private String state;

    @NotNull(message = "Pincode is required.")
    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be a 6-digit number.")
    private Integer pincode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private NaishaAirlineUser user;

}
