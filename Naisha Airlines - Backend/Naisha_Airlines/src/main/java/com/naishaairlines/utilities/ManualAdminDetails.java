package com.naishaairlines.utilities;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.naishaairlines.models.Admin;

public class ManualAdminDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private Admin admin;

	public ManualAdminDetails(Admin admin) {
		super();
		this.admin = admin;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return admin.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return admin.isActive();
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return admin.isActive();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return admin.isActive();
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
