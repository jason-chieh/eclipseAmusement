package com.example.parkview.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adminuser")
public class AdminUser {
	
	@Id
	@Column(name="account")
	private String account;
	
	@Column(name="password")
	private String pwd;
	
	@Column(name="manage_place")
	private String managePlace;
	
	@Column(name="manage_num")
	private int manageNum;

	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminUser(String account, String pwd, String managePlace, int manageNum) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.managePlace = managePlace;
		this.manageNum = manageNum;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getManagePlace() {
		return managePlace;
	}

	public void setManagePlace(String managePlace) {
		this.managePlace = managePlace;
	}

	public int getManageNum() {
		return manageNum;
	}

	public void setManageNum(int manageNum) {
		this.manageNum = manageNum;
	}
	
	

}
