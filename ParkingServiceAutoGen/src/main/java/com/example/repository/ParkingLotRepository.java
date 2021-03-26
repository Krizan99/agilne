package com.example.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Parkinglot;

public interface ParkingLotRepository extends JpaRepository<Parkinglot,Integer> {

	Collection<Parkinglot> findByNameContainingIgnoreCase(String name);

}
