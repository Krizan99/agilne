package com.example.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Owner;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {

	Collection<Owner> findByFnameContainingIgnoreCase(String fname);

}
