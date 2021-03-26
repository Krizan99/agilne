package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zone")
public class Zone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer priceperday;

	private Integer priceperhour;

	private String zonetype;

	public Zone() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPriceperday() {
		return this.priceperday;
	}

	public void setPriceperday(Integer priceperday) {
		this.priceperday = priceperday;
	}

	public Integer getPriceperhour() {
		return this.priceperhour;
	}

	public void setPriceperhour(Integer priceperhour) {
		this.priceperhour = priceperhour;
	}

	public String getZonetype() {
		return this.zonetype;
	}

	public void setZonetype(String zonetype) {
		this.zonetype = zonetype;
	}

}
