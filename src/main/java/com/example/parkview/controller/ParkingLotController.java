package com.example.parkview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkview.service.ifs.ParkingLotService;
import com.example.parkview.vo.ParkingLotServiceReq;
import com.example.parkview.vo.ParkingLotServiceRes;

@RestController
@CrossOrigin 
public class ParkingLotController {

	@Autowired
	private ParkingLotService service;

	@GetMapping(value = "api/parkingLot/searchAll")
	public ParkingLotServiceRes searchAll(@RequestParam String license) {
		return service.searchAll(license);
	}

	@GetMapping(value = "api/parkingLot/search")
	public ParkingLotServiceRes search(@RequestParam String license) {
		return service.search(license);
	}

	@PostMapping(value = "api/parkingLot/admission")
	public ParkingLotServiceRes admission(@RequestBody ParkingLotServiceReq req) {
		return service.admission(req);
	}

	@PostMapping(value = "api/parkingLot/departure")
	public ParkingLotServiceRes departure(@RequestBody ParkingLotServiceReq req) {
		return service.departure(req);
	
	}
	
	@PostMapping(value = "api/parkingLot/deleteParkingInfo")
	public ParkingLotServiceRes delete(@RequestBody ParkingLotServiceReq req) {
		return service.delete(req);
	}
}
