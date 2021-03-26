package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	private Boolean isparked;

	private String mark;

	private String plates;
	
	//bi-directional many-to-one association to Owner
	@ManyToOne
	@JoinColumn(name="ownerid")
	private Owner owner;

	public Vehicle() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsparked() {
		return isparked;
	}

	public void setIsparked(Boolean isparked) {
		this.isparked = isparked;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getPlates() {
		return plates;
	}

	public void setPlates(String plates) {
		this.plates = plates;
	}
	
}
