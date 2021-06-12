package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.TennisAdmin;

public interface AdminRepository extends JpaRepository<TennisAdmin, Integer>{

}
