package com.example.parkview.service.ifs;

import java.util.List;

import com.example.parkview.entity.Facility;
import com.example.parkview.vo.BasicRes;
import com.example.parkview.vo.FacilityReq;

public interface ParkService {

	public BasicRes create(Facility facility);
	
//	public BasicRes savePhoto(byte[] imageData ,String name);
	
	public byte[] getPhoto(String name);
	
	
	
}
