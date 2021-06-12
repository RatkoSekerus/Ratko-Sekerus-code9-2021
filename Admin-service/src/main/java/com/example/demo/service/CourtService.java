package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CourtRepository;

import model.TennisCourt;

@Service
public class CourtService {
	@Autowired
	CourtRepository courtRepository;
	
	public TennisCourt addCourt(TennisCourt a) {
		return courtRepository.save(a);
	}
	public void deleteCourt(TennisCourt a) {
		courtRepository.delete(a);
	}
	public void deleteCourtById(Integer id) {
		courtRepository.deleteById(id);
	}
	
}
