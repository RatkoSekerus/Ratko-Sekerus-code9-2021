package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.TennisPlayer;

@Repository
public interface PlayerRepository extends CrudRepository<TennisPlayer, Integer> {

}
