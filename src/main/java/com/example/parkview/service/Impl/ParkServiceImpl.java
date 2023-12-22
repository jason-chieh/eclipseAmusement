package com.example.parkview.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkview.constants.RtnCode;
import com.example.parkview.entity.Facility;
import com.example.parkview.repository.FacilityDao;
import com.example.parkview.service.ifs.ParkService;
import com.example.parkview.vo.BasicRes;
import com.example.parkview.vo.FacilityReq;

@Service
public class ParkServiceImpl implements ParkService {

		@Autowired
		private FacilityDao dao;
		
		
		//�x�s��Ƥ��a�Ӥ�
		@Override
		public BasicRes create(Facility facility) {
			dao.save(facility);
			return new BasicRes(RtnCode.SUCCESSFUL);
		}


		@Override
		public byte[] getPhoto(String name) {
			Optional<Facility> op = dao.findById(name);
			if(op.isEmpty()) {
				return null;
			}
			return op.get().getPhoto();
		}

//
//		//�x�s�Ӥ��a�Jpk
//		@Override
//		public BasicRes savePhoto(byte[] imageData ,String name) {
//			Optional<Facility> op = dao.findById(name);
//			Facility facility = op.get();
//			facility.setPhoto(imageData);
//			dao.save(facility);
//			return new BasicRes(RtnCode.SUCCESSFUL);
//		}

		
		
		
		
}
