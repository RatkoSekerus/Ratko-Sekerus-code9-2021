package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.AdminService;


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
	
	@GetMapping()
	public ResponseEntity<List<TennisAdmin>> admins() {
		List<TennisAdmin> ta = adminService.admins();
		return new ResponseEntity<>(ta,HttpStatus.OK);
	}
	

	
}
