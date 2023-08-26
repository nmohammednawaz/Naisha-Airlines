package com.naishaairlines.utilities;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.naishaairlines.models.Passenger;

public class ManualPassengerDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Passenger passenger;

	public ManualPassengerDetails(Passenger passenger) {
		super();
		this.passenger = passenger;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return passenger.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return passenger.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return passenger.isActive();
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return passenger.isActive();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return passenger.isActive();
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
