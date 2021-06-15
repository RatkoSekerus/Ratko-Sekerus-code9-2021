package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.json.ReservationJSON;
import com.example.demo.service.AdminReservationService;

import model.TennisReservation;

@RestController
@RequestMapping("/adminReservationController")
public class AdminReservationController {
	
	@Autowired
	AdminReservationService adminReservationService;
	@DeleteMapping("/{id}")
	public ResponseEntity<TennisReservation> deleteReservationById(@PathVariable("id") Integer id) {
		try { adminReservationService.deleteReservationById(id);
		return  new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("addReservation")
	public ResponseEntity<TennisReservation> addReservation(@RequestBody ReservationJSON reservation) {
		System.out.println("cntrla");
		TennisReservation tr = adminReservationService.addReservation(reservation);
		if ( tr != null ) {
		return  new ResponseEntity<>(HttpStatus.OK);
		} else {
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
