package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PlayerRepository;

import model.TennisCourt;
import model.TennisPlayer;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	public TennisPlayer addPlayer(TennisPlayer p) {
		return playerRepository.save(p);
	}
	public void deletePlayer(TennisPlayer p) {
		playerRepository.delete(p);
	}
	public void deletPlayerById(Integer id) {
		playerRepository.deleteById(id);
	}
	
}
