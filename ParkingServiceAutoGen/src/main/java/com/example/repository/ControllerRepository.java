package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Controller;

public interface ControllerRepository extends JpaRepository<Controller,Integer> {

}
