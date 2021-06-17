package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.TennisPlayer;



@Repository
public interface PlayerRepository extends CrudRepository<TennisPlayer, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE TennisPlayer SET money=?1 WHERE playerID =?2")
	void updateMoney(Integer money, Integer id);
	
}
