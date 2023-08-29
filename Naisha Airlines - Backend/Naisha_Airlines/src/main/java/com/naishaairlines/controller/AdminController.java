package com.naishaairlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.naishaairlines.dto.LoginRequest;
import com.naishaairlines.models.Admin;
import com.naishaairlines.service.AdminServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admins")
public class AdminController {
	
	@Autowired
	private AdminServices adminServices;
	
//	@Autowired
//	private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@Valid @RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminServices.registerAdmin(admin), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginAdmin(Authentication authentication){
		System.out.println(authentication.toString());
		Admin admin = adminServices.findAdminByUsername(authentication.getName());
		return new ResponseEntity<String>(admin.getUsername() + " Sign In SuccessFull..!", HttpStatus.OK);
	}
	
//	@PostMapping("/login")
//	public ResponseEntity<String> loginAdmin(@RequestBody LoginRequest loginRequest){
//		Admin admin = adminServices.findAdminByUsername(loginRequest.getUsername());
////		Authentication authentication = 
//		return new ResponseEntity<String>(admin.getUsername() + " Sign In SuccessFull..!", HttpStatus.OK);
//	}
	
	
	
}
