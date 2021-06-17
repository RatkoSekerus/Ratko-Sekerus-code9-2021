package com.example.demo.payment;

import org.springframework.stereotype.Service;

import model.TennisPlayer;


public class PaymentWithCache extends Payment {
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

	public PaymentWithCache(int money, int playerID) {
		
		super();
		System.out.println("cnstr"+ money + " " + playerID);
		this.money = money;
		this.playerID = playerID;
		System.out.println("cnstr"+ this.money + " " + this.playerID);
	}
	

}
