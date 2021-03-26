package com.example.demo;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class VehiclecheckedPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer controllerid;

	private Integer vehicleid;

	public VehiclecheckedPK() {
	}
	public Integer getControllerid() {
		return this.controllerid;
	}
	public void setControllerid(Integer controllerid) {
		this.controllerid = controllerid;
	}
	public Integer getVehicleid() {
		return this.vehicleid;
	}
	public void setVehicleid(Integer vehicleid) {
		this.vehicleid = vehicleid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VehiclecheckedPK)) {
			return false;
		}
		VehiclecheckedPK castOther = (VehiclecheckedPK)other;
		return 
			this.controllerid.equals(castOther.controllerid)
			&& this.vehicleid.equals(castOther.vehicleid);
	
	}
}
