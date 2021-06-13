package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import model.TennisCourt;

@Service
public class AdminCourtService {
	@Autowired
	private RestTemplate restTemplate;
	
	
	public TennisCourt addCourt(TennisCourt court) {
		return restTemplate.postForObject("http://localhost:8081/courtService/courtController/addCourt/",court,TennisCourt.class);
	}
	
	public TennisCourt deleteCourt(TennisCourt court) { 
		return  restTemplate.postForObject("http://localhost:8081/courtService/courtController/deleteCourt/",court,TennisCourt.class);
	}
	
	public void deleteCourtById(Integer id) {
		 restTemplate.delete("http://localhost:8081/courtService/courtController/"+id);		
	}
}
