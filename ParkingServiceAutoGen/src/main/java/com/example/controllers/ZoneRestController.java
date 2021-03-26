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

import com.example.demo.Zone;
import com.example.repository.ZoneRepository;

public class ZoneRestController {

	@Autowired
	private ZoneRepository zoneRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/zone")
	public Collection<Zone> getzonei() {
		return zoneRepository.findAll();
	}

	@GetMapping("/zone/{id}")
	public Zone getOneById(@PathVariable("id") Integer id) {
		return zoneRepository.getOne(id);
	}

	@GetMapping("/zone/naziv/{ime}")
	public Collection<Zone> getByNaziv(@PathVariable("ime") String name) {
		return zoneRepository.findByZonetypeContainingIgnoreCase(name);
	}

	@PostMapping("/zone")
	public ResponseEntity<HttpStatus> insertzonejac(@RequestBody Zone zone) {
		if (!zoneRepository.existsById(zone.getId())) {
			zoneRepository.save(zone);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);

	}

	@PutMapping("/zone/{id}")
	public ResponseEntity<HttpStatus> updatezone(@RequestBody Zone zone,
			@PathVariable("id") Integer id) {

		if (zoneRepository.existsById(id)) {
			zone.setId(id);
			zoneRepository.save(zone);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
/*
	@DeleteMapping("zone/{id}")
	public ResponseEntity<HttpStatus> deletezone(@PathVariable("id") Integer id) {
		if (!zoneRepository.existsById(id))
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		zoneRepository.deleteById(id);
		if (id == -100)
			jdbcTemplate.execute(" INSERT INTO \"zone\" (\"id\", \"naziv\", \"zone\")"
					+ " VALUES (-100, 'Naziv Test', 'zone Test')");
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

*/

}
