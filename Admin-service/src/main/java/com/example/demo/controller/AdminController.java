package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AdminService;
import com.example.demo.service.CourtService;

import model.TennisAdmin;
import model.TennisCourt;

@RestController
@RequestMapping("/adminController")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	
	@PostMapping("addAdmin")
	public ResponseEntity<TennisAdmin> addAdmin(@RequestBody TennisAdmin admin) {
		TennisAdmin ta = adminService.addAdmin(admin);
		return new ResponseEntity<>(ta,HttpStatus.OK);
	}

	
}
