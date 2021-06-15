package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.TennisReservation;

@Repository
public interface ReservationRepository extends CrudRepository<TennisReservation,Integer>{

}
