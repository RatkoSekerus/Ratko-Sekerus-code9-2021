package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.TennisAdmin;

@Repository
public interface AdminRepository extends JpaRepository<TennisAdmin, Integer>{

}
