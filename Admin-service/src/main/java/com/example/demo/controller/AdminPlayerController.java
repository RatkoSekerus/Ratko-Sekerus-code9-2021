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

import com.example.demo.service.AdminPlayerService;


import model.TennisPlayer;

@RestController
@RequestMapping("/adminPlayerController")
public class AdminPlayerController {
	
	@Autowired
	AdminPlayerService adminPlayerService;
	
	@PostMapping("addPlayer")
	public ResponseEntity<TennisPlayer> addPlayer(@RequestBody TennisPlayer player) {
		TennisPlayer tp = adminPlayerService.addPlayer(player);
		return  new ResponseEntity<>(tp,HttpStatus.OK);
	}
	@PostMapping("deletePlayer")
	public ResponseEntity<TennisPlayer> deletePlayer(@RequestBody TennisPlayer player) {
		TennisPlayer tp = adminPlayerService.deletePlayer(player);
		return  new ResponseEntity<>(tp,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<TennisPlayer> deletePlayerById(@PathVariable("id") Integer id) {
		try { adminPlayerService.deletePlayerById(id);
		return  new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
