package com.example.demo.payment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PlayerRepository;
import com.example.demo.service.PlayerService;

import model.TennisPlayer;


public class Payment {

	
	private int money;
	private int playerID;
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public int getCcv() {
		return 0;
	}
	public int getCardNumber() {
		return 0;
	}
}
