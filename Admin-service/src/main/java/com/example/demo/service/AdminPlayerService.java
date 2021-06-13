package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;


import model.TennisPlayer;

@Service
public class AdminPlayerService {

	@Autowired
	private RestTemplate restTemplate;
	
	public TennisPlayer addPlayer(TennisPlayer player) {
		return restTemplate.postForObject("http://localhost:8082/playerService/playerController/addPlayer/",player,TennisPlayer.class);
	}
	
	public TennisPlayer deletePlayer(TennisPlayer player) { 
		return  restTemplate.postForObject("http://localhost:8082/playerService/playerController/deletePlayer/",player,TennisPlayer.class);
	}
	
	public void deletePlayerById(Integer id) {
		 restTemplate.delete("http://localhost:8082/playerService/playerController/"+id);		
	}
}
