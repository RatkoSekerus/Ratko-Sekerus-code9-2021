package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.payment.Payment;
import com.example.demo.repository.PlayerRepository;

import model.TennisAdmin;
import model.TennisCourt;
import model.TennisPlayer;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	public TennisPlayer addPlayer(TennisPlayer p) {
		List<TennisPlayer> l = (List<TennisPlayer>) playerRepository.findAll();
		for (TennisPlayer tp : l ) {
			if (tp.getEmail().equals(p.getEmail())) {
				return null;
			}
		}
		return playerRepository.save(p);
	}
	public void deletePlayer(TennisPlayer p) {
		playerRepository.delete(p);
	}
	public void deletPlayerById(Integer id) {
		playerRepository.deleteById(id);
	}
	public List<TennisPlayer> players() {
		return (List<TennisPlayer>) playerRepository.findAll();
	}

	public TennisPlayer getPlayerById(Integer id) {
		TennisPlayer tp = ((Collection<TennisPlayer>) playerRepository.findAll()).stream()
				.filter(p -> p.getPlayerID()==id)
				.findFirst()
				.orElse(null);
		return tp;
	}
	public TennisPlayer getPlayerByEmail(String email) {
		TennisPlayer tp = ((Collection<TennisPlayer>) playerRepository.findAll()).stream()
				.filter(p -> p.getEmail().equals(email))
				.findFirst()
				.orElse(null);
		return tp;
	}
	public Integer getPlayerIDByEmail(String email) {
		Integer tp = ((Collection<TennisPlayer>) playerRepository.findAll()).stream()
				.filter(p -> p.getEmail().equals(email))
				.findFirst()
				.map(p->p.getPlayerID())
				.orElse(null);
		return tp;
	}
	public void pay(Payment p) {
		int id = p.getPlayerID();
		int money = p.getMoney();
		System.out.println("servist");
		TennisPlayer tp = getPlayerById(id);
		playerRepository.updateMoney(money+tp.getMoney(), id);
		
	}
	
}
