package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import model.TennisCourt;

public interface CourtRepository extends CrudRepository <TennisCourt,Integer>{

}
