package com.example.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Zone;

public interface ZoneRepository extends JpaRepository<Zone,Integer> {

	Collection<Zone> findByZonetypeContainingIgnoreCase(String name);

}
