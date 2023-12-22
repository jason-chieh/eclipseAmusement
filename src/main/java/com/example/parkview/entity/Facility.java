package com.example.parkview.entity;

import java.sql.Blob;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="facility")
public class Facility {

	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="place")
	private String place;
	
	@Column(name="published")
	private boolean published;
	
	@Column(name="photo")
	private byte[] photo;
	
	@Column(name="age")
	private int age;
	
	@Column(name="start_date")
	private LocalDate startDate;

	@Column(name="end_date")
	private LocalDate endDate;
	
	@Column(name="photoS")
	private String photoS;
	
	@Column(name="reserve_num")
	private int reserveNum;
	
	
	

	public Facility() {
		super();
		// TODO Auto-generated constructor stub
	}


	



	public Facility(String name, String description, String place, boolean published, byte[] photo, int age,
			LocalDate startDate, LocalDate endDate, String photoS) {
		super();
		this.name = name;
		this.description = description;
		this.place = place;
		this.published = published;
		this.photo = photo;
		this.age = age;
		this.startDate = startDate;
		this.endDate = endDate;
		this.photoS = photoS;
	}



	public Facility(String name, String description, String place, boolean published, byte[] photo, int age,
			LocalDate startDate, LocalDate endDate, String photoS, int reserveNum) {
		super();
		this.name = name;
		this.description = description;
		this.place = place;
		this.published = published;
		this.photo = photo;
		this.age = age;
		this.startDate = startDate;
		this.endDate = endDate;
		this.photoS = photoS;
		this.reserveNum = reserveNum;
	}






	public int getReserveNum() {
		return reserveNum;
	}






	public void setReserveNum(int reserveNum) {
		this.reserveNum = reserveNum;
	}






	public String getPhotoS() {
		return photoS;
	}



	public void setPhotoS(String photoS) {
		this.photoS = photoS;
	}



	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	
	
	
}
