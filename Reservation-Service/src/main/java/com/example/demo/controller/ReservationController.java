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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.json.ReservationJSON;
import com.example.demo.service.ReservationService;

import model.TennisPlayer;
import model.TennisReservation;

@RestController
@RequestMapping("/reservationController")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@PostMapping("addReservation")
	public ResponseEntity<TennisReservation> addReservation(@RequestBody ReservationJSON reservationJson) {
		TennisReservation reservation = reservationService.getReservation(reservationJson);
		TennisReservation tr = reservationService.addReservation(reservation);
		if (tr == null ) {
			
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<TennisReservation> deleteReservationById(@PathVariable("id") Integer id) {
		try {
			reservationService.deletReservationById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping()
	public ResponseEntity<List<TennisReservation>> reservation() {
		List<TennisReservation> tp = reservationService.reservations();
		return new ResponseEntity<>(tp,HttpStatus.OK);
	}
}
