package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.json.ReservationJSON;

import model.TennisPlayer;
import model.TennisReservation;

@Service
public class AdminReservationService {

	@Autowired
	private RestTemplate restTemplate;
	
	public void deleteReservationById(Integer id) {
		 restTemplate.delete("http://localhost:8083/reservationService/reservationController/"+id);		
	}
	public TennisReservation addReservation(ReservationJSON reservation) {
		return restTemplate.postForObject("http://localhost:8083/reservationService/reservationController/addReservation/",reservation,TennisReservation.class);
	}
}
