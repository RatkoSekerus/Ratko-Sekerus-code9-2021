package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.TennisCourt;

@Repository
public interface CourtRepository extends CrudRepository<TennisCourt,Integer>{

}
