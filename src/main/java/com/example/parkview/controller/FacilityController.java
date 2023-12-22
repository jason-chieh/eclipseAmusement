package com.example.parkview.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.parkview.constants.RtnCode;
import com.example.parkview.entity.Facility;
import com.example.parkview.entity.ReserveFacility;
import com.example.parkview.repository.FacilityDao;
import com.example.parkview.repository.ReserveFacilityDao;
import com.example.parkview.service.ifs.ParkService;
import com.example.parkview.service.ifs.ReserveFacilityService;
import com.example.parkview.vo.BasicRes;
import com.example.parkview.vo.FacilityReq;
import com.example.parkview.vo.ReserveReq;
import com.mysql.cj.jdbc.Blob;

@RestController
@CrossOrigin      //�o�ӬO�s�e��
public class FacilityController {
	
	@Autowired
	private ParkService service;
	
	@Autowired
	private FacilityDao facilityDao;
	
	@Autowired
	private ReserveFacilityService reserveFacilityService;
	
	@Autowired
	private ReserveFacilityDao reserveFacilityDao;
	

	
	//�s�W�C�ֳ]�I
	@PostMapping(value = "api/park/create")
	public BasicRes create(@RequestBody FacilityReq req) {
		Facility  fa = req.getFacility();
		String base64String = fa.getPhotoS();
		byte[] imageBytes = Base64.getDecoder().decode(base64String.split(",")[1]);
		
		fa.setPhoto(imageBytes);
		fa.setPhotoS("");	
		return service.create(fa);
	}
	
	@GetMapping(value = "api/park/get")
	public byte[] get(@RequestParam(value = "name", required = false) String name) {
		byte[] imageData = service.getPhoto(name);
		return imageData;
	}
	
	//�e�ݥD�e�������H�}�񪺹C�ֳ]�I
	@GetMapping(value = "api/park/getAllFacility")
	public List<Facility> searchIsPublished() {
		return facilityDao.searchFacilityIsPublished();
	}

	//��ݺ޲z�������������]�I
	@GetMapping(value = "api/park/getAllFacilityFromBack")
	public List<Facility> searchFacilityAll(){
		return facilityDao.searchFacilityAll();
	}
	
	//��ݺ޲z����-�T�ӱ���h�M��
	@GetMapping(value = "api/park/searchThreeCondition")
	public List<Facility> searchThreeCondition(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "place", required = false) String place,
			@RequestParam(value = "published",  defaultValue = "true") boolean published){
		return facilityDao.searchThreeCondition(name, place, published);
	}
	
	//��ݺ޲z����-��ӱ���h�M��
	@GetMapping(value = "api/park/searchTwoCondition")
	public List<Facility> searchTwoCondition(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "place", required = false) String place){
			return facilityDao.searchTwoCondition(name, place);
	}
		
	//��ݺ޲z����-�R���]�I
	@PostMapping(value = "api/park/deleteFacility")
	public BasicRes  deleteFacility(@RequestParam(value = "name", required = false) String name) {
			facilityDao.deleteFacility(name);
		return new BasicRes(RtnCode.SUCCESSFUL);
	}	
	
	
	//��ݺ޲z����-��s�]�I
	@PostMapping(value = "api/park/updateFacility")	
	public BasicRes updateFacility(
			@RequestParam(value = "oldname", required = false) String oldname,//
			@RequestBody FacilityReq req ) {
			
			Facility  fa = req.getFacility();
			String base64String = fa.getPhotoS();
			byte[] imageBytes = Base64.getDecoder().decode(base64String.split(",")[1]);	
			fa.setPhoto(imageBytes);
			fa.setPhotoS("");	
			
			facilityDao.updateFacility(fa.getName(), oldname, fa.getDescription(),
					fa.getPlace(), fa.isPublished(),
					fa.getPhoto(), fa.getAge(), fa.getStartDate(),fa.getEndDate(),fa.getPhotoS());
		return new BasicRes(RtnCode.SUCCESSFUL);
	}
		
		
	//�e�ݨϥΪ�-�w���]�I
	@PostMapping(value = "api/park/reserveFacility")
	public BasicRes reserveFacility(@RequestParam String facilityname) {
		facilityDao.reserveFacility(facilityname);
		return new BasicRes(RtnCode.SUCCESSFUL);
	}
	
	//�e�ݨϥΪ�-�w���]�I-�åB�s�W�w���Ӷ�
	@PostMapping(value = "api/park/addReserveInfo")
	public BasicRes addReserveInfo(@RequestBody ReserveReq req) {
		return reserveFacilityService.reserve(req);
	}
	
	
	//�R���ϥΪ̹w��������
	@GetMapping(value = "api/park/deleteReserveFacility")
	public BasicRes deleteReserveFacility(
			@RequestParam(value = "facilityname", required = false) String facilityname,
			@RequestParam(value = "uuid", required = false) String uuid) {
		reserveFacilityDao.deleteReserveFacility(uuid, facilityname);
		facilityDao.chanelreserveFacility(facilityname);
		return new BasicRes(RtnCode.SUCCESSFUL);
	}

		

}
