package com.example.parkview.vo;

import java.util.List;

import com.example.parkview.constants.RtnCode;
import com.example.parkview.entity.ParkingLot;

public class ParkingLotServiceRes {
	
	private RtnCode rtncode;

	private ParkingLot parkingLot;

	private List<ParkingLot> parkingInfoList;

	private int parkingFee = 0;

	public ParkingLotServiceRes() {
		super();

	}

	public ParkingLotServiceRes(RtnCode rtncode, List<ParkingLot> parkingInfoList) {
		super();
		this.rtncode = rtncode;
		this.parkingInfoList = parkingInfoList;
	}

	public ParkingLotServiceRes(RtnCode rtncode, int parkingFee) {
		super();
		this.rtncode = rtncode;
		this.parkingFee = parkingFee;
	}

	public ParkingLotServiceRes(RtnCode rtncode) {
		super();
		this.rtncode = rtncode;
	}

	public ParkingLotServiceRes(RtnCode rtncode, ParkingLot parkingLot) {
		super();
		this.rtncode = rtncode;
		this.parkingLot = parkingLot;
	}

	public RtnCode getRtncode() {
		return rtncode;
	}

	public void setRtncode(RtnCode rtncode) {
		this.rtncode = rtncode;
	}

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public int getParkingFee() {
		return parkingFee;
	}

	public void setParkingFee(int parkingFee) {
		this.parkingFee = parkingFee;
	}

	public List<ParkingLot> getParkingInfoList() {
		return parkingInfoList;
	}

	public void setParkingInfoList(List<ParkingLot> parkingInfoList) {
		this.parkingInfoList = parkingInfoList;
	}
	
}
