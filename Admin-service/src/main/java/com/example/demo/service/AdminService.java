package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CourtRepository;

import model.TennisAdmin;
import model.TennisCourt;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	
	
	public TennisAdmin addAdmin(TennisAdmin a) {
		return adminRepository.save(a);
	}
	
	

}
