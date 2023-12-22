package com.example.parkview.vo;

import com.example.parkview.constants.RtnCode;

public class BuyTicketRes {
	
	private String uuid ;
	
	private RtnCode rtncode;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public RtnCode getRtncode() {
		return rtncode;
	}

	public void setRtncode(RtnCode rtncode) {
		this.rtncode = rtncode;
	}

	public BuyTicketRes(String uuid, RtnCode rtncode) {
		super();
		this.uuid = uuid;
		this.rtncode = rtncode;
	}
	
	
    

}
