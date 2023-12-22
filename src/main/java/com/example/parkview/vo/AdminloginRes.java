package com.example.parkview.vo;

import com.example.parkview.constants.RtnCode;
import com.example.parkview.entity.AdminUser;

public class AdminloginRes {
	
	private AdminUser adminuser;
	
	private RtnCode rtncode;

	public AdminUser getAdminuser() {
		return adminuser;
	}

	public void setAdminuser(AdminUser adminuser) {
		this.adminuser = adminuser;
	}

	public RtnCode getRtncode() {
		return rtncode;
	}
	
	

	public AdminloginRes(AdminUser adminuser, RtnCode rtncode) {
		super();
		this.adminuser = adminuser;
		this.rtncode = rtncode;
	}

	public void setRtncode(RtnCode rtncode) {
		this.rtncode = rtncode;
	}
	

	
}
