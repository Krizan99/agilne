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

import com.example.demo.Payment;
import com.example.repository.PaymentRepository;

public class PaymentRestController {

	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/payment")
	public Collection<Payment> getpaymenti() {
		return paymentRepository.findAll();
	}

	@GetMapping("/payment/{id}")
	public Payment getOneById(@PathVariable("id") Integer id) {
		return paymentRepository.getOne(id);
	}

	/*@GetMapping("/payment/naziv/{ime}")
	public Collection<Payment> getByNaziv(@PathVariable("ime") String name) {
		return paymentRepository.findByNameContainingIgnoreCase(name);
	}*/

	@PostMapping("/payment")
	public ResponseEntity<HttpStatus> insertpayment(@RequestBody Payment payment) {
		if (!paymentRepository.existsById(payment.getId())) {
			paymentRepository.save(payment);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);

	}

	@PutMapping("/payment/{id}")
	public ResponseEntity<HttpStatus> updatepayment(@RequestBody Payment payment,
			@PathVariable("id") Integer id) {

		if (paymentRepository.existsById(id)) {
			payment.setId(id);
			paymentRepository.save(payment);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
/*
	@DeleteMapping("payment/{id}")
	public ResponseEntity<HttpStatus> deletepayment(@PathVariable("id") Integer id) {
		if (!paymentRepository.existsById(id))
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		paymentRepository.deleteById(id);
		if (id == -100)
			jdbcTemplate.execute(" INSERT INTO \"payment\" (\"id\", \"naziv\", \"payment\")"
					+ " VALUES (-100, 'Naziv Test', 'payment Test')");
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

*/


}
