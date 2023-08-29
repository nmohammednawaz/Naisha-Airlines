package com.naishaairlines.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naishaairlines.configurations.PasswordEncoderConfiguration;
import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Admin;
import com.naishaairlines.repository.AdminRepository;

@Service
public class AdminServiceImplements implements AdminServices {
	
	@Autowired
	private PasswordEncoderConfiguration passwordEncoderConfiguration;
	
	@Autowired
	private AdminRepository adminRepository;
	
	private void checkDuplicate(String emailId, String username, String contactNumber) throws DuplicateDataException {
		if(adminRepository.existsByEmailId(emailId)) {
			throw new DuplicateDataException("Dear User, Email Id Already Registered");
		}
		if(adminRepository.existsByUsername(username)) {
			throw new DuplicateDataException("Dear User, Username Already Registered");
		}
		if(adminRepository.existsByContactNumber(contactNumber)) {
			throw new DuplicateDataException("Dear User, Contact Number Already Registered");
		}
	}

	@Override
	public Admin registerAdmin(Admin admin) throws DuplicateDataException {
		
		checkDuplicate(admin.getEmailId(), admin.getUsername(), admin.getContactNumber());
		
		admin.setPassword(passwordEncoderConfiguration.passwordEncoder().encode(admin.getPassword()));
		return adminRepository.save(admin);
	}

	@Override
	public Admin findAdminById(Integer adminId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return adminRepository.findById(adminId).orElseThrow(() -> new NoDataFoundException("Dear User, No Admin Found With Id: " + adminId));
	}

	@Override
	public Admin findAdminByEmailId(String emailId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return adminRepository.findByEmailId(emailId).orElseThrow(() -> new NoDataFoundException("Dear User, No Admin Found With Email Id: " + emailId));
	}

	@Override
	public Admin findAdminByUsername(String username) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return adminRepository.findByUsername(username).orElseThrow(() -> new NoDataFoundException("Dear User, No Admin Found Username: " + username));
	}

	@Override
	public Admin updateAdmin(Admin admin) throws DuplicateDataException {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public Admin deActivateAdmin(Integer adminId) throws NoDataFoundException {
		
		Optional<Admin> adminOptional = adminRepository.findById(adminId);
	    
	    if (!adminOptional.isPresent()) {
	        throw new NoDataFoundException("No Admin Found With Id: " + adminId);
	    }
	    
	    Admin admin = adminOptional.get();
	    admin.setActive(false);
	    
	    return adminRepository.save(admin);
	}

	@Override
	public List<Admin> viewAllAdmins() throws NoDataFoundException {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

}
