package com.example.parkview.service.ifs;

import com.example.parkview.vo.ParkingLotServiceReq;
import com.example.parkview.vo.ParkingLotServiceRes;

public interface ParkingLotService {

	public ParkingLotServiceRes searchAll(String license);
	
	public ParkingLotServiceRes search(String license);
	
	public ParkingLotServiceRes delete( ParkingLotServiceReq req);

	public ParkingLotServiceRes admission(ParkingLotServiceReq req);

	public ParkingLotServiceRes departure(ParkingLotServiceReq req);
}
