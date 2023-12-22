package com.example.parkview.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PlayerFacilityVo {
	
	private int id;
	
	private String facilityName ;
	
	private String uuid ;
	
	private String facilityPlace ;
	
	private int age;
	
	private byte[] photo;

	public PlayerFacilityVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerFacilityVo(int id, String facilityName, String uuid, String facilityPlace, int age, byte[] photo) {
		super();
		this.id = id;
		this.facilityName = facilityName;
		this.uuid = uuid;
		this.facilityPlace = facilityPlace;
		this.age = age;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFacilityPlace() {
		return facilityPlace;
	}

	public void setFacilityPlace(String facilityPlace) {
		this.facilityPlace = facilityPlace;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	

}
