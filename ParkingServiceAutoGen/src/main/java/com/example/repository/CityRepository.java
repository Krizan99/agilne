package com.example.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.City;


public interface CityRepository extends JpaRepository<City,Integer> {

	Collection<City> findByCitynameContainingIgnoreCase(String cityname);

}
