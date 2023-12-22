package com.example.parkview.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkview.constants.RtnCode;
import com.example.parkview.entity.ReserveFacility;
import com.example.parkview.repository.ReserveFacilityDao;
import com.example.parkview.service.ifs.ReserveFacilityService;
import com.example.parkview.vo.BasicRes;
import com.example.parkview.vo.ReserveReq;

@Service
public class ReserveFacilityServiceImpl implements ReserveFacilityService {
	
	@Autowired
	private ReserveFacilityDao dao;
	
	
	@Override
	public BasicRes reserve(ReserveReq req) {
//		List<ReserveFacility>  ResFaList = dao.findByUuid(req.getReserveFacility().getUuid());
//		for(ReserveFacility item:ResFaList) {
//			if(item.getFacilityName()==req.getReserveFacility().getFacilityName()) {
//				return new BasicRes(RtnCode.RESERVE_IS_ALREADY);
//			}
//		}
		dao.save(req.getReserveFacility());
		return new BasicRes(RtnCode.SUCCESSFUL);
	}
	
	
}
