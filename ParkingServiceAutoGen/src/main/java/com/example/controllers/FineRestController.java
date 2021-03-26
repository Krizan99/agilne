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

import com.example.demo.Fine;
import com.example.repository.FineRepository;

public class FineRestController {

	@Autowired
	private FineRepository fineRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/fine")
	public Collection<Fine> getfinei() {
		return fineRepository.findAll();
	}

	@GetMapping("/fine/{id}")
	public Fine getOneById(@PathVariable("id") Integer id) {
		return fineRepository.getOne(id);
	}

	/*@GetMapping("/fine/naziv/{ime}")
	public Collection<Fine> getByNaziv(@PathVariable("ime") String fname) {
		return fineRepository.findByFnameContainingIgnoreCase(fname);
	}*/

	@PostMapping("/fine")
	public ResponseEntity<HttpStatus> insertfinejac(@RequestBody Fine fine) {
		if (!fineRepository.existsById(fine.getId())) {
			fineRepository.save(fine);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);

	}

	@PutMapping("/fine/{id}")
	public ResponseEntity<HttpStatus> updatefine(@RequestBody Fine fine,
			@PathVariable("id") Integer id) {

		if (fineRepository.existsById(id)) {
			fine.setId(id);
			fineRepository.save(fine);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
/*
	@DeleteMapping("fine/{id}")
	public ResponseEntity<HttpStatus> deletefine(@PathVariable("id") Integer id) {
		if (!fineRepository.existsById(id))
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		fineRepository.deleteById(id);
		if (id == -100)
			jdbcTemplate.execute(" INSERT INTO \"fine\" (\"id\", \"naziv\", \"fine\")"
					+ " VALUES (-100, 'Naziv Test', 'fine Test')");
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

*/
}
