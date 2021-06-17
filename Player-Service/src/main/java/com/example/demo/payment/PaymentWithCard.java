package com.example.demo.payment;

import org.springframework.stereotype.Service;

import model.TennisPlayer;


public class PaymentWithCard extends Payment{
	
	private int cardNumber;
	private int ccv;
	private int money;
	private int playerID;
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCcv() {
		return ccv;
	}
	public void setCcv(int ccv) {
		this.ccv = ccv;
	}
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
	public PaymentWithCard(int cardNumber, int ccv, int money, int playerID) {
		super();

		this.cardNumber = cardNumber;
		this.ccv = ccv;
		this.money = money;
		this.playerID = playerID;
		
	}
	
	
	
	
}
