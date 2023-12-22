package com.example.parkview.controller;


import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.parkview.constants.RtnCode;
import com.example.parkview.entity.AdminUser;
import com.example.parkview.entity.Player;
import com.example.parkview.entity.ReserveFacility;
import com.example.parkview.repository.AdminUserDao;
import com.example.parkview.repository.PlayerDao;
import com.example.parkview.repository.ReserveFacilityDao;
import com.example.parkview.service.ifs.AdminUserService;
import com.example.parkview.vo.AddminInfoReq;
import com.example.parkview.vo.AdminloginReq;
import com.example.parkview.vo.AdminloginRes;
import com.example.parkview.vo.BasicRes;
import com.example.parkview.vo.BuyTicketReq;
import com.example.parkview.vo.BuyTicketRes;
import com.example.parkview.vo.FacilityReq;
import com.example.parkview.vo.ForgetTicketRes;
import com.example.parkview.vo.PlayerFacilityVo;
import com.example.parkview.vo.PlayerLoginRes;

import Qrcode.QRCodeGenerator;
import mail.JavaMail;



@RestController
@CrossOrigin      //�o�ӬO�s�e��
public class AdminUserController {
	
	@Autowired
	private AdminUserService service;
	
	@Autowired
	private AdminUserDao dao;
	
	@Autowired
	private ReserveFacilityDao reserveFacilityDao;
	
	@Autowired
	private PlayerDao palyerDao;
	

	
	
	
	//�إߺ޲z��
	@PostMapping(value="api/addminUser/addAdminInfo")
	public BasicRes addAdminInfo(@RequestBody AddminInfoReq req) {
		
		return service.addAdminInfo(req);
	}
	
	
	//��s�޲z�H��
	@PostMapping(value = "api/addminUser/updateAdminUser")	
	public BasicRes updateAdminUser(
			@RequestParam(value = "oldaccount", required = false) String oldaccount,//
			@RequestBody AddminInfoReq req) {
			dao.updateAdminUser(req.getAdminuser().getAccount(), oldaccount,
					req.getAdminuser().getPwd(), req.getAdminuser().getManagePlace(),
					req.getAdminuser().getManageNum());
		return new BasicRes(RtnCode.SUCCESSFUL);
	}
	
	
	//�R���޲z�̪�
	@GetMapping(value="api/addminUser/deleteAdminuser")
	public BasicRes deleteAdminUser(
			@RequestParam(value = "account" , required = false) String account) {
		dao.deleteAdminUser(account);
		return new BasicRes(RtnCode.SUCCESSFUL);
	}
	
	
	//�j�M�޲z��-�a�T�ӱ���
	@GetMapping(value = "api/addminUser/searchAdminuser")
	public List<AdminUser> searchAdminuser(
			@RequestParam(value = "account", required = false) String account,
			@RequestParam(value = "place", required = false) String place,
			@RequestParam(value = "position", required = false) Integer position){
		return dao.searchAdminuser(account, place, position);
	}
	
	//�j�M�޲z��-�a��ӱ���
	@GetMapping(value = "api/addminUser/searchAdminuserByTwo")
	public List<AdminUser> searchAdminuserByTwo(
			@RequestParam(value = "account", required = false) String account,
			@RequestParam(value = "place", required = false) String place){
		return dao.searchAdminuserByTwo(account, place);
	}
	
	//�޲z�̵n�J
	@PostMapping(value = "api/addminUser/login")
	public AdminloginRes login(@RequestBody AdminloginReq req, HttpSession session) {
		AdminloginRes res =  service.login(req.getAccount(), req.getPwd());
		System.out.println("session"+session.getId());
		if(res.getRtncode().getCode()==200) {
			session.setAttribute("account", req.getAccount());
			session.setAttribute("password", req.getPwd());
			session.setMaxInactiveInterval(300);  //�]�wsession���Įɶ�300��
			return new AdminloginRes(res.getAdminuser() ,RtnCode.SUCCESSFUL);
		}
		return new AdminloginRes(null,RtnCode.LOGIN_ERROR);
	}
	
	
	//�޲z�̵n�X
	@PostMapping(value = "api/addminUser/logout")
	public BasicRes logout(HttpSession session) {	
			System.out.println("session"+session.getId());
			session.invalidate();
			return new BasicRes(RtnCode.SUCCESSFUL);
	}
			
	
	//�ʲ��ϥΪ�
	@PostMapping(value = "api/player/buyTicket")
	public  BuyTicketRes  buyTicket(@RequestBody BuyTicketReq req) {
		return service.buyTicket(req);
	}
	
	
	//�ʲ��n�J
	@PostMapping(value = "api/player/playerLogin")
	public  PlayerLoginRes  playerLogin(@RequestParam(value = "uuid", required = false) String uuid,HttpSession session) {
		PlayerLoginRes res = service.playerLogin(uuid);
		if(res.getRtncode().getCode()==200) {
			System.out.println(session.getId());
			session.setAttribute("uuid", res.getPlayer().getUuid());
			session.setMaxInactiveInterval(300);  //�]�wsession���Įɶ�300��
			return new PlayerLoginRes(res.getPlayer() ,RtnCode.SUCCESSFUL);

		}
		if(res.getRtncode().getCode()==404) {
			return new PlayerLoginRes(null ,RtnCode.PLAYDATE_IS_NOT_ALREADY);
		}
		return new PlayerLoginRes(null ,RtnCode.LOGIN_ERROR);
	}
	
	//�e�ݨϥΪ�-�w���]�I-�j�M���n�J�̦��w�����򶵥�
	@GetMapping(value = "api/park/searchReserveFacility")
	public List<ReserveFacility> search(@RequestParam(value = "uuid", required = false) String uuid){
		return reserveFacilityDao.searchReserveFacility(uuid);
	}
	
	//�e�ݨϥΪ�-�w���]�I-�j�M���n�J�̦��w�����򶵥�
	@GetMapping(value = "api/park/searchReserveFacility1")
	public List<PlayerFacilityVo> search1(@RequestParam(value = "uuid", required = false) String uuid){
		return reserveFacilityDao.searchReserve(uuid);
	}
	
	
	
	//�ѰO����qrcode
	@GetMapping(value = "api/adminuser/forgetQrcode")
	public ForgetTicketRes forgetQrcode(
		@RequestParam(value = "email", required = false) String email,
		@RequestParam(value = "playdate", required = false)@DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate playdate) {
		List<Player> playerList = palyerDao.forgetQrcode(email, playdate);
		if(playerList.isEmpty()) {
			return new ForgetTicketRes(null,RtnCode.PLAYER_NO_EXIST);
		}	
		
		for( Player item : playerList) {
			JavaMail mail= new JavaMail();
			mail.setCustomer(item.getEmail());
			mail.setTxt(item.getUuid());
			mail.SendMail();
		}
		return new ForgetTicketRes(playerList,RtnCode.SUCCESSFUL);
	}
	
	
	
	
	
	
	
}
