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

import com.example.demo.payment.JsonForAllpayments;
import com.example.demo.payment.Payment;

import com.example.demo.payment.PaymentWithCache;
import com.example.demo.payment.PaymentWithCard;
import com.example.demo.service.PlayerService;

import model.TennisAdmin;
import model.TennisCourt;
import model.TennisPlayer;

@RestController
@RequestMapping("/playerController")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	

	Payment payment;
	
	@PostMapping("addPlayer")
	public ResponseEntity<TennisPlayer> addPlayer(@RequestBody TennisPlayer player) {
		TennisPlayer tp = playerService.addPlayer(player);
		if (tp == null ) {
		return new ResponseEntity<>(tp,HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(tp,HttpStatus.OK);
		}
	}
	@PostMapping("addMoney")
	public ResponseEntity<TennisPlayer> addMoney(@RequestBody JsonForAllpayments paymentJson) {	
		
			if (paymentJson.getCardNumber() != 0 ) {
				payment = new PaymentWithCard(paymentJson.getCardNumber(),paymentJson.getCcv(),paymentJson.getMoney(),paymentJson.getPlayerID());
			} else {
				payment = new PaymentWithCache(paymentJson.getMoney(),paymentJson.getPlayerID());
			}
			playerService.pay( payment);
			return new ResponseEntity<>(HttpStatus.OK);
	
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
	@GetMapping()
	public ResponseEntity<List<TennisPlayer>> players() {
		List<TennisPlayer> tp = playerService.players();
		return new ResponseEntity<>(tp,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<TennisPlayer> getPlayerById(@PathVariable("id") Integer id) {
		TennisPlayer tp = playerService.getPlayerById(id);
		return new ResponseEntity<>(tp,HttpStatus.OK);
	}
}
