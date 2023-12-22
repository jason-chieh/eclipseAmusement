package com.example.parkview.vo;

import com.example.parkview.constants.RtnCode;

public class BasicRes {

	private RtnCode rtnCode;

	public BasicRes(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}
	
	
}
