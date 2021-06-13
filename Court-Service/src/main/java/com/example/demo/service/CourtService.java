package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.repository.CourtRepository;

import model.TennisCourt;

@Service
public class CourtService {
	@Autowired
	CourtRepository courtRepository;
	
	public TennisCourt addCourt(TennisCourt a) {
		List<TennisCourt> l = (List<TennisCourt>) courtRepository.findAll();
		for (TennisCourt tc : l ) {
			if (tc.getName().equals(a.getName())) {
				return null;
			}
		}
		return courtRepository.save(a);
	}
	public void deleteCourt(TennisCourt a) {
		courtRepository.delete(a);
	}
	public void deleteCourtById(Integer id) {
		courtRepository.deleteById(id);
	}
	
	public TennisCourt getCourtById(Integer id) {
		TennisCourt tc = ((Collection<TennisCourt>) courtRepository.findAll()).stream()
				.filter(c -> c.getCourtID()==id)
				.findFirst()
				.orElse(null);
		return tc;
	}
	
}