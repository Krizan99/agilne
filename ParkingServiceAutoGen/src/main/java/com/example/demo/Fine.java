package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="fine")
public class Fine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String date;

	private double price;

	private Boolean status;

	//bi-directional many-to-one association to Vehiclechecked
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="controllerid", referencedColumnName="controllerid"),
		@JoinColumn(name="vehicleid", referencedColumnName="vehicleid")
		})
	private Vehiclechecked vehiclechecked;

	public Fine() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Vehiclechecked getVehiclechecked() {
		return this.vehiclechecked;
	}

	public void setVehiclechecked(Vehiclechecked vehiclechecked) {
		this.vehiclechecked = vehiclechecked;
	}
}
