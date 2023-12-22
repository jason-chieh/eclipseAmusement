package com.example.parkview.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="facilityreserve")
public class ReserveFacility {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="facility_name")
	private String facilityName ;
	
	@Column(name="uuid")
	private String uuid ;
	
	@Column(name="facility_place")
	private String facilityPlace ;
	
	@Column(name="age")
	private int age;
	

	public ReserveFacility() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ReserveFacility(int id, String facilityName, String uuid, String facilityPlace, int age) {
		super();
		this.id = id;
		this.facilityName = facilityName;
		this.uuid = uuid;
		this.facilityPlace = facilityPlace;
		this.age = age;
	}




	public ReserveFacility( String facilityName, String uuid, String facilityPlace, int age) {
		super();
		this.facilityName = facilityName;
		this.uuid = uuid;
		this.facilityPlace = facilityPlace;
		this.age = age;
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
	
	
	
	
	
}
