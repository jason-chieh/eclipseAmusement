package com.example.parkview.service.Impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.parkview.constants.RtnCode;
import com.example.parkview.entity.ParkingLot;
import com.example.parkview.repository.ParkingLotDao;
import com.example.parkview.service.ifs.ParkingLotService;
import com.example.parkview.vo.ParkingLotServiceReq;
import com.example.parkview.vo.ParkingLotServiceRes;

@Service
public class ParkingLotServiceImpl implements ParkingLotService{
	
	@Autowired
	ParkingLotDao parkingLotDao;

	@CacheEvict(cacheNames = "search", allEntries = true)
	@Override
	public ParkingLotServiceRes search(String license) {
		Optional<ParkingLot> parkingInfoOp = parkingLotDao.findById(license);
		if (parkingInfoOp.isEmpty()) {
			return new ParkingLotServiceRes(RtnCode.LICENSE_PLATE_NUMBER_NOT_FOUND);
		}
		ParkingLot parkingInfo = parkingInfoOp.get();
//		System.out.println(parkingInfo.getLicense());
		return new ParkingLotServiceRes(RtnCode.SERACH_SUCCESSFUL, parkingInfo);
	}
	
	@CacheEvict(cacheNames = "searchAll", allEntries = true)
	@Override
	public ParkingLotServiceRes searchAll(String license) {
		System.out.println(license);
		if(!StringUtils.hasText(license)) {			
			license = StringUtils.hasText(license) ? license : "";
			List<ParkingLot> parkingInfoList = parkingLotDao.findAll();
			return new ParkingLotServiceRes(RtnCode.SERACH_SUCCESSFUL,parkingInfoList);
		}
		Optional<ParkingLot> parkingInfoOp = parkingLotDao.findById(license);
		if (parkingInfoOp.isEmpty()) {
			return new ParkingLotServiceRes(RtnCode.LICENSE_PLATE_NUMBER_NOT_FOUND);
		}
		ParkingLot parkingInfo = parkingInfoOp.get();
		
		return new ParkingLotServiceRes(RtnCode.SERACH_SUCCESSFUL, parkingInfo);
	}

	@Transactional
	@Override
	public ParkingLotServiceRes departure(ParkingLotServiceReq req) {
		Optional<ParkingLot> parkingInfoOp = parkingLotDao.findById(req.getLicense());
		ParkingLot parkingInfo = parkingInfoOp.get();
		if (parkingInfoOp.isEmpty()) {
			return new ParkingLotServiceRes(RtnCode.LICENSE_PLATE_NUMBER_NOT_FOUND);
		}

		LocalDateTime admissionTimePlus30Minutes = parkingInfo.getAdmissionTime().plus(30, ChronoUnit.MINUTES);
		// 判斷是否在30分鐘內，如果是則不用停車費
		if (LocalDateTime.now().isBefore(admissionTimePlus30Minutes)) {
			ParkingLot updateInfo = new ParkingLot(parkingInfo.getLicense(), parkingInfo.getVehicleType(),
					parkingInfo.getAdmissionTime(), LocalDateTime.now(), req.getParkingFee());
			parkingLotDao.save(updateInfo);
			return new ParkingLotServiceRes(RtnCode.PAYMENT_SUCCESSFUL);

		} else if (req.getParkingFee() == 0) {
			return new ParkingLotServiceRes(RtnCode.PAYMENT_FAIL);
		} else if (parkingInfo.getParkingFee() > 0) {
			return new ParkingLotServiceRes(RtnCode.IS_ALREADY_PAID);
		}
		ParkingLot updateInfo = new ParkingLot(parkingInfo.getLicense(), parkingInfo.getVehicleType(),
				parkingInfo.getAdmissionTime(), LocalDateTime.now(), req.getParkingFee());
		parkingLotDao.save(updateInfo);
		return new ParkingLotServiceRes(RtnCode.PAYMENT_SUCCESSFUL);

	}

	@Transactional
	@Override
	public ParkingLotServiceRes admission(ParkingLotServiceReq req) {
		if (!StringUtils.hasText(req.getLicense()) || !StringUtils.hasText(req.getVehicleType())) {
			return new ParkingLotServiceRes(RtnCode.PARAM_ERROR);
		}
		// 判斷重複進場
		Optional<ParkingLot> parkingOp = parkingLotDao.findById(req.getLicense());
		if (parkingOp.isPresent()) {
			return new ParkingLotServiceRes(RtnCode.NO_DUPLICATE_ADMISSION);
		}
		ParkingLot parkingLot = new ParkingLot(req.getLicense(), req.getVehicleType(), LocalDateTime.now(), 0);
		parkingLotDao.save(parkingLot);
		return new ParkingLotServiceRes(RtnCode.ADMISSION_SUCCESSFUL);
	}

	@Override
	public ParkingLotServiceRes delete( ParkingLotServiceReq req) {
		Optional<ParkingLot> parkiingInfoOp = parkingLotDao.findById(req.getLicense());
		if(parkiingInfoOp.isEmpty()) {
			return new ParkingLotServiceRes(RtnCode.LICENSE_PLATE_NUMBER_NOT_FOUND);
		}
		parkingLotDao.deleteById(req.getLicense());
		return new ParkingLotServiceRes(RtnCode.DELETE_SUCCESSFUL);
	}

}
