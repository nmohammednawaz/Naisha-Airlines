package com.naishaairlines.model;

import com.naishaairlines.enums.UserRole;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class NaishaAirlineUser {

    private Long naishaAirlineUserId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailId;
    private Integer phonenumber;
    private Boolean isActive;
    private LocalDate dateOfBirth;
    private UserRole role;
    private String profilePictureUrl;
    private List<Address> addressList;
    private List<Passenger> passengerList;
    private List<Booking> bookingHistory;
    private List<Transaction> transactionHistory;

}
