package com.example.parkview.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {
	
	@Id
	@Column(name="UUID")
	private String uuid;
	
	@Column(name="nickname")
	private String nickname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="age")
	private int age ;
	
	@Column(name="play_date")
	private LocalDate playDate;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(String uuid, String nickname, String email, int age, LocalDate playDate) {
		super();
		this.uuid = uuid;
		this.nickname = nickname;
		this.email = email;
		this.age = age;
		this.playDate = playDate;
	}
	
	

	public Player(String nickname, String email, int age, LocalDate playDate) {
		super();
		this.nickname = nickname;
		this.email = email;
		this.age = age;
		this.playDate = playDate;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getPlayDate() {
		return playDate;
	}

	public void setPlayDate(LocalDate playDate) {
		this.playDate = playDate;
	}
	
	
	

}
