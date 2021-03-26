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

import com.example.demo.City;
import com.example.repository.CityRepository;

public class CityRestController {
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/city")
	public Collection<City> getcityi() {
		return cityRepository.findAll();
	}

	@GetMapping("/city/{id}")
	public City getOneById(@PathVariable("id") Integer id) {
		return cityRepository.getOne(id);
	}

	@GetMapping("/city/naziv/{ime}")
	public Collection<City> getByNaziv(@PathVariable("ime") String cityname) {
		return cityRepository.findByCitynameContainingIgnoreCase(cityname);
	}

	@PostMapping("/city")
	public ResponseEntity<HttpStatus> insertcityjac(@RequestBody City city) {
		if (!cityRepository.existsById(city.getId())) {
			cityRepository.save(city);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);

	}

	@PutMapping("/city/{id}")
	public ResponseEntity<HttpStatus> updatecity(@RequestBody City city,
			@PathVariable("id") Integer id) {

		if (cityRepository.existsById(id)) {
			city.setId(id);
			cityRepository.save(city);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
/*
	@DeleteMapping("city/{id}")
	public ResponseEntity<HttpStatus> deletecity(@PathVariable("id") Integer id) {
		if (!cityRepository.existsById(id))
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		cityRepository.deleteById(id);
		if (id == -100)
			jdbcTemplate.execute(" INSERT INTO \"city\" (\"id\", \"naziv\", \"city\")"
					+ " VALUES (-100, 'Naziv Test', 'city Test')");
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

*/
}
