package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Fine;

public interface FineRepository extends JpaRepository<Fine,Integer> {

}
