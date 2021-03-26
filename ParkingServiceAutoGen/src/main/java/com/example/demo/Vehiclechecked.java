package com.example.demo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="vehiclechkecked")
public class Vehiclechecked implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VehiclecheckedPK id;

	//bi-directional many-to-one association to Fine
	@JsonIgnore
	@OneToMany(mappedBy="vehiclechecked")
	private List<Fine> fines;

	public Vehiclechecked() {
	}

	public VehiclecheckedPK getId() {
		return this.id;
	}

	public void setId(VehiclecheckedPK id) {
		this.id = id;
	}

	public List<Fine> getFines() {
		return this.fines;
	}

	public void setFines(List<Fine> fines) {
		this.fines = fines;
	}

	public Fine addFine(Fine fine) {
		getFines().add(fine);
		fine.setVehiclechecked(this);

		return fine;
	}

	public Fine removeFine(Fine fine) {
		getFines().remove(fine);
		fine.setVehiclechecked(null);

		return fine;
	}

}
