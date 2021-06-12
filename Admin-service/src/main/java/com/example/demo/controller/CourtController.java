package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CourtService;

import model.TennisCourt;

@RestController
@RequestMapping("/courtController")
public class CourtController {
	
	@Autowired
	private CourtService courtService;
	
	
	@PostMapping("addCourt")
	public ResponseEntity<TennisCourt> addCourt(@RequestBody TennisCourt court) {
		TennisCourt tc = courtService.addCourt(court);
		return new ResponseEntity<>(tc,HttpStatus.OK);
	}
	
	@PostMapping("deleteCourt")
	public ResponseEntity<TennisCourt> deleteCourt(@RequestBody TennisCourt court) {
		try {
			courtService.deleteCourt(court);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<TennisCourt> deleteCourtById(@PathVariable("id") Integer id) {
		try {
			courtService.deleteCourtById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
