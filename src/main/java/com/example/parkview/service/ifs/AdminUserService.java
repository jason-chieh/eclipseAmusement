package com.example.parkview.service.ifs;

import java.time.LocalDate;

import com.example.parkview.vo.AddminInfoReq;
import com.example.parkview.vo.AdminloginRes;
import com.example.parkview.vo.BasicRes;
import com.example.parkview.vo.BuyTicketReq;
import com.example.parkview.vo.BuyTicketRes;
import com.example.parkview.vo.PlayerLoginRes;

public interface AdminUserService {

	public BasicRes addAdminInfo(AddminInfoReq req);
	
	public AdminloginRes login(String account,String pwd);
	
	public  BuyTicketRes  buyTicket(BuyTicketReq req);
	
	public  PlayerLoginRes  playerLogin(String uuid);
	
}
