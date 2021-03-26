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

import com.example.demo.Vehicle;
import com.example.repository.VehicleRepository;

public class VehicleRestController {

	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/vehicle")
	public Collection<Vehicle> getvehiclei() {
		return vehicleRepository.findAll();
	}

	@GetMapping("/vehicle/{id}")
	public Vehicle getOneById(@PathVariable("id") Integer id) {
		return vehicleRepository.getOne(id);
	}

	@GetMapping("/vehicle/naziv/{ime}")
	public Collection<Vehicle> getByNaziv(@PathVariable("ime") String name) {
		return vehicleRepository.findByPlatesContainingIgnoreCase(name);
	}

	@PostMapping("/vehicle")
	public ResponseEntity<HttpStatus> insertvehiclejac(@RequestBody Vehicle vehicle) {
		if (!vehicleRepository.existsById(vehicle.getId())) {
			vehicleRepository.save(vehicle);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);

	}

	@PutMapping("/vehicle/{id}")
	public ResponseEntity<HttpStatus> updatevehicle(@RequestBody Vehicle vehicle,
			@PathVariable("id") Integer id) {

		if (vehicleRepository.existsById(id)) {
			vehicle.setId(id);
			vehicleRepository.save(vehicle);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
/*
	@DeleteMapping("vehicle/{id}")
	public ResponseEntity<HttpStatus> deletevehicle(@PathVariable("id") Integer id) {
		if (!vehicleRepository.existsById(id))
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		vehicleRepository.deleteById(id);
		if (id == -100)
			jdbcTemplate.execute(" INSERT INTO \"vehicle\" (\"id\", \"naziv\", \"vehicle\")"
					+ " VALUES (-100, 'Naziv Test', 'vehicle Test')");
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

*/

}
