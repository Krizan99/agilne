package com.example.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Owner;
import com.example.repository.OwnerRepository;


public class OwnerRestController {
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/owner")
	public Collection<Owner> getowneri() {
		return ownerRepository.findAll();
	}

	@GetMapping("/owner/{id}")
	public Owner getOneById(@PathVariable("id") Integer id) {
		return ownerRepository.getOne(id);
	}

	@GetMapping("/owner/naziv/{ime}")
	public Collection<Owner> getByNaziv(@PathVariable("ime") String fname) {
		return ownerRepository.findByFnameContainingIgnoreCase(fname);
	}

	@PostMapping("/owner")
	public ResponseEntity<HttpStatus> insertownerjac(@RequestBody Owner owner) {
		if (!ownerRepository.existsById(owner.getId())) {
			ownerRepository.save(owner);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);

	}

	@PutMapping("/owner/{id}")
	public ResponseEntity<HttpStatus> updateowner(@RequestBody Owner owner,
			@PathVariable("id") Integer id) {

		if (ownerRepository.existsById(id)) {
			owner.setId(id);
			ownerRepository.save(owner);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
/*
	@DeleteMapping("owner/{id}")
	public ResponseEntity<HttpStatus> deleteowner(@PathVariable("id") Integer id) {
		if (!ownerRepository.existsById(id))
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		ownerRepository.deleteById(id);
		if (id == -100)
			jdbcTemplate.execute(" INSERT INTO \"owner\" (\"id\", \"naziv\", \"owner\")"
					+ " VALUES (-100, 'Naziv Test', 'owner Test')");
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

*/
}