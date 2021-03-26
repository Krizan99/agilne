package com.example.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Vehiclechecked;
import com.example.repository.VehicleCheckedRepository;

public class VehicleCheckedRestController {

	@Autowired
	private VehicleCheckedRepository vehiclecheckedRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/vehiclechecked")
	public Collection<Vehiclechecked> getvehiclecheckedi() {
		return vehiclecheckedRepository.findAll();
	}

	@GetMapping("/vehiclechecked/{id}")
	public Vehiclechecked getOneById(@PathVariable("id") Integer id) {
		return vehiclecheckedRepository.getOne(id);
	}

	/*@GetMapping("/vehiclechecked/naziv/{ime}")
	public Collection<Vehiclechecked> getByNaziv(@PathVariable("ime") String name) {
		return vehiclecheckedRepository.findByNameContainingIgnoreCase(name);
	}*/

	@PostMapping("/vehiclechecked")
	public ResponseEntity<HttpStatus> insertvehiclecheckedjac(@RequestBody Vehiclechecked vehiclechecked) {
		if (!vehiclecheckedRepository.existsById(vehiclechecked.getId())) {
			vehiclecheckedRepository.save(vehiclechecked);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);

	}

	@PutMapping("/vehiclechecked/{id}")
	public ResponseEntity<HttpStatus> updatevehiclechecked(@RequestBody Vehiclechecked vehiclechecked,
			@PathVariable("id") Integer id) {

		if (vehiclecheckedRepository.existsById(id)) {
			vehiclechecked.setId(id);
			vehiclecheckedRepository.save(vehiclechecked);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
/*
	@DeleteMapping("vehiclechecked/{id}")
	public ResponseEntity<HttpStatus> deletevehiclechecked(@PathVariable("id") Integer id) {
		if (!vehiclecheckedRepository.existsById(id))
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		vehiclecheckedRepository.deleteById(id);
		if (id == -100)
			jdbcTemplate.execute(" INSERT INTO \"vehiclechecked\" (\"id\", \"naziv\", \"vehiclechecked\")"
					+ " VALUES (-100, 'Naziv Test', 'vehiclechecked Test')");
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

*/

}
