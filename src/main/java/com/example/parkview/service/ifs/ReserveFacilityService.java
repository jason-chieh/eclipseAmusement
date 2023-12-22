package com.example.parkview.service.ifs;

import com.example.parkview.vo.BasicRes;
import com.example.parkview.vo.ReserveReq;

public interface ReserveFacilityService {
		
	public BasicRes reserve(ReserveReq req);
}
