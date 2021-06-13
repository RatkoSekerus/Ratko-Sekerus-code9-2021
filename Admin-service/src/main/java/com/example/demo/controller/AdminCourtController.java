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
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.AdminCourtService;

import model.TennisCourt;


@RestController
@RequestMapping("/adminCourtController")
public class AdminCourtController {
		
	@Autowired
	AdminCourtService adminCourtService;
	
	@PostMapping("addCourt")
	public ResponseEntity<TennisCourt> addCourt(@RequestBody TennisCourt court) {
		TennisCourt tc = adminCourtService.addCourt(court);
		return  new ResponseEntity<>(tc,HttpStatus.OK);
	}
	@PostMapping("deleteCourt")
	public ResponseEntity<TennisCourt> deleteCourt(@RequestBody TennisCourt court) {
		TennisCourt tc = adminCourtService.deleteCourt(court);
		return  new ResponseEntity<>(tc,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<TennisCourt> deleteCourtById(@PathVariable("id") Integer id) {
		try { adminCourtService.deleteCourtById(id);
		return  new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
