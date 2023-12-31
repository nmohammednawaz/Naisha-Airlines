package com.naishaairlines.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Admin;

public interface AdminServices {
	
	Admin registerAdmin(Admin admin) throws DuplicateDataException;
	Admin loginAdmin(Authentication authentication) throws NoDataFoundException;
	Admin findAdminById(Integer adminId) throws NoDataFoundException;
	Admin findAdminByEmailId(String emailId) throws NoDataFoundException;
	Admin findAdminByUsername(String username) throws NoDataFoundException;
	Admin updateAdmin(Admin admin) throws DuplicateDataException;
	Admin deActivateAdmin(Integer adminId) throws NoDataFoundException;
	List<Admin> viewAllAdmins() throws NoDataFoundException;
}
