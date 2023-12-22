package com.example.parkview.vo;

import java.time.LocalDateTime;

import com.example.parkview.entity.ParkingLot;

public class ParkingLotServiceReq {
	private ParkingLot parkingLot;

	private String license;

	private String vehicleType;

	private LocalDateTime admissionTime;

	private LocalDateTime departureTime;

	private int parkingFee;

	public ParkingLotServiceReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParkingLotServiceReq(String license) {
		super();
		this.license = license;
	}

	public ParkingLotServiceReq(String license, String vehicleType) {
		super();
		this.license = license;
		this.vehicleType = vehicleType;
	}

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public ParkingLotServiceReq(ParkingLot parkingLot) {
		super();
		this.parkingLot = parkingLot;
	}

	public ParkingLotServiceReq(String license, String vehicleType, LocalDateTime admissionTime) {
		super();
		this.license = license;
		this.vehicleType = vehicleType;
		this.admissionTime = admissionTime;
	}

	public ParkingLotServiceReq(String license, int parkingFee) {
		super();
		this.license = license;
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

	public int getParkingFee() {
		return parkingFee;
	}

	public void setParkingFee(int parkingFee) {
		this.parkingFee = parkingFee;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
}
