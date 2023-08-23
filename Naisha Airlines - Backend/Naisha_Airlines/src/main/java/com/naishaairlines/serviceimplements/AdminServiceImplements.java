package com.naishaairlines.serviceimplements;

import java.util.List;

import com.naishaairlines.exceptions.DuplicateDataException;
import com.naishaairlines.exceptions.NoDataFoundException;
import com.naishaairlines.models.Admin;
import com.naishaairlines.service.AdminServices;

public class AdminServiceImplements implements AdminServices {

	@Override
	public Admin registerAdmin(Admin admin) throws DuplicateDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findAdminById(Integer adminId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findAdminByEmailId(String emailId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findAdminByUsername(String username) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin updateAdmin(Admin admin) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin deActivateAdmin(Integer adminId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> viewAllAdmins() throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
