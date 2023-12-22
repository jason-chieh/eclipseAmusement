package com.example.parkview.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parkinglot")
public class ParkingLot {

	@Id
	@Column(name = "license")
	private String license;

	@Column(name = "vehicle_type")
	private String vehicleType;

	@Column(name = "admission_time")
	private LocalDateTime admissionTime;

	@Column(name = "departure_time")
	private LocalDateTime departureTime;

	@Column(name = "parking_fee")
	private int parkingFee;

	public ParkingLot() {
		super();
	}

	public ParkingLot(String license, String vehicleType, LocalDateTime admissionTime, int parkingFee) {
		super();
		this.license = license;
		this.vehicleType = vehicleType;
		this.admissionTime = admissionTime;
		this.parkingFee = parkingFee;
	}

	public ParkingLot(String license, String vehicleType, LocalDateTime admissionTime, LocalDateTime departureTime) {
		super();
		this.license = license;
		this.vehicleType = vehicleType;
		this.admissionTime = admissionTime;
		this.departureTime = departureTime;
	}
	
	

	public ParkingLot(String license, String vehicleType, LocalDateTime admissionTime, LocalDateTime departureTime,
			int parkingFee) {
		super();
		this.license = license;
		this.vehicleType = vehicleType;
		this.admissionTime = admissionTime;
		this.departureTime = departureTime;
		this.parkingFee = parkingFee;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public LocalDateTime getAdmissionTime() {
		return admissionTime;
	}

	public void setAdmissionTime(LocalDateTime admissionTime) {
		this.admissionTime = admissionTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getParkingFee() {
		return parkingFee;
	}

	public void setParkingFee(int parkingFee) {
		this.parkingFee = parkingFee;
	}



}