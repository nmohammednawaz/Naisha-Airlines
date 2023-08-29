package com.naishaairlines.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.naishaairlines.models.Admin;
import com.naishaairlines.models.Passenger;
import com.naishaairlines.repository.AdminRepository;
import com.naishaairlines.repository.PassengerRepository;

@Service
public class ManualUserDetailsService implements UserDetailsService {
    
	@Autowired
	 private PassengerRepository passengerRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	public boolean isAdmin(String username) {
	   Optional<Admin> admin = adminRepository.findByUsername(username);
		if(admin.isPresent()) return true;
		else return false;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(isAdmin(username)) {
			Optional<Admin> optionalAdmin = adminRepository.findByUsername(username);
			 
			if(optionalAdmin.isEmpty()) throw new UsernameNotFoundException("Admin not found");
			Admin admin = optionalAdmin.get();
			 
			List<GrantedAuthority> authorities = new ArrayList<>() ;
			SimpleGrantedAuthority autho = new SimpleGrantedAuthority("ROLE_"+admin.getRole().toUpperCase()) ;
			authorities.add(autho) ;
			
			User secUser = new User(admin.getUsername(), admin.getPassword(),  authorities) ;
			return secUser ;
			
		}else {
			
			Optional<Passenger> optionalPassenger = passengerRepository.findByUsername(username);
				 
				if(optionalPassenger.isEmpty()) throw new UsernameNotFoundException("User not found");
				
				Passenger passenger = optionalPassenger.get();
				
				List<GrantedAuthority> authorities = new ArrayList<>() ;
				SimpleGrantedAuthority autho = new SimpleGrantedAuthority("ROLE_"+passenger.getRole().toUpperCase()) ;
				authorities.add(autho) ;
				
				User secUser = new User(passenger.getUsername(), passenger.getPassword(),  authorities) ;
				return secUser ;
				
			}
		}


}