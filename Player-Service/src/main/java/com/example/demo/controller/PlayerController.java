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

import com.example.demo.service.PlayerService;

import model.TennisPlayer;

@RestController
@RequestMapping("/playerController")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	
	@PostMapping("addPlayer")
	public ResponseEntity<TennisPlayer> addPlayer(@RequestBody TennisPlayer player) {
		TennisPlayer tp = playerService.addPlayer(player);
		return new ResponseEntity<>(tp,HttpStatus.OK);
	}
	
	@PostMapping("deletePlayer")
	public ResponseEntity<TennisPlayer> deletePlayer(@RequestBody TennisPlayer player) {
		try {
			playerService.deletePlayer(player);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<TennisPlayer> deletePlayerById(@PathVariable("id") Integer id) {
		try {
			playerService.deletPlayerById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
