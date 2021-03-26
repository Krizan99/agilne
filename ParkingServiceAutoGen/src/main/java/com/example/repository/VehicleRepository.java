package com.example.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

	Collection<Vehicle> findByPlatesContainingIgnoreCase(String name);

}
