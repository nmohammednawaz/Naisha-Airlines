package com.naishaairlines.model;

import jakarta.persistence.Entity;

@Entity
public class Address {

    private String address;
    private String city;
    private String state;
    private Integer pindcode;
    private NaishaAirlineUser user;


}
