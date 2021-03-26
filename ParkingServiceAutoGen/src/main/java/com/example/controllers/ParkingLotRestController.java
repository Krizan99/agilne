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

import com.example.demo.Parkinglot;
import com.example.repository.ParkingLotRepository;

public class ParkingLotRestController {

	@Autowired
	private ParkingLotRepository parkinglotRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/parkinglot")
	public Collection<Parkinglot> getparkingloti() {
		return parkinglotRepository.findAll();
	}

	@GetMapping("/parkinglot/{id}")
	public Parkinglot getOneById(@PathVariable("id") Integer id) {
		return parkinglotRepository.getOne(id);
	}

	@GetMapping("/parkinglot/naziv/{ime}")
	public Collection<Parkinglot> getByNaziv(@PathVariable("ime") String name) {
		return parkinglotRepository.findByNameContainingIgnoreCase(name);
	}

	@PostMapping("/parkinglot")
	public ResponseEntity<HttpStatus> insertparkinglotjac(@RequestBody Parkinglot parkinglot) {
		if (!parkinglotRepository.existsById(parkinglot.getId())) {
			parkinglotRepository.save(parkinglot);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);

	}

	@PutMapping("/parkinglot/{id}")
	public ResponseEntity<HttpStatus> updateparkinglot(@RequestBody Parkinglot parkinglot,
			@PathVariable("id") Integer id) {

		if (parkinglotRepository.existsById(id)) {
			parkinglot.setId(id);
			parkinglotRepository.save(parkinglot);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
/*
	@DeleteMapping("parkinglot/{id}")
	public ResponseEntity<HttpStatus> deleteparkinglot(@PathVariable("id") Integer id) {
		if (!parkinglotRepository.existsById(id))
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		parkinglotRepository.deleteById(id);
		if (id == -100)
			jdbcTemplate.execute(" INSERT INTO \"parkinglot\" (\"id\", \"naziv\", \"parkinglot\")"
					+ " VALUES (-100, 'Naziv Test', 'parkinglot Test')");
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

*/

}
