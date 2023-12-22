package com.example.parkview.service.Impl;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.parkview.constants.RtnCode;
import com.example.parkview.entity.AdminUser;
import com.example.parkview.entity.Player;
import com.example.parkview.repository.AdminUserDao;
import com.example.parkview.repository.PlayerDao;
import com.example.parkview.service.ifs.AdminUserService;
import com.example.parkview.vo.AddminInfoReq;
import com.example.parkview.vo.AdminloginRes;
import com.example.parkview.vo.BasicRes;
import com.example.parkview.vo.BuyTicketReq;
import com.example.parkview.vo.BuyTicketRes;
import com.example.parkview.vo.PlayerLoginRes;

@Service
public class AdminUserServiceImpl implements AdminUserService {
	
	@Autowired
	private AdminUserDao dao;
	
	@Autowired
	private PlayerDao playerdao;
	
	
	//創建管理者資訊
	@Override
	public BasicRes addAdminInfo(AddminInfoReq req) {
		dao.save(req.getAdminuser());
		return new BasicRes(RtnCode.SUCCESSFUL);
	}

	
	//管理者登入
	@Override
	public AdminloginRes login(String account, String pwd) {
		if(!StringUtils.hasText(account)||!StringUtils.hasText(pwd)) {
			return new AdminloginRes(null,RtnCode.ACCOUNT_AND_PWD_NONE);
		}
		Optional<AdminUser> op = dao.findById(account);
		if(op.isEmpty()) {
			return new AdminloginRes(null,RtnCode.ACCOUNT_NOTFOUND);
		}
		if(!(op.get().getPwd().matches(pwd))) {
			return new AdminloginRes(null,RtnCode.PWD_ERROR);
		}
		op.get().setPwd("");
		return new AdminloginRes(op.get(),RtnCode.SUCCESSFUL);
	}

	
//	玩家購買票卷
	@Override
	public BuyTicketRes buyTicket(BuyTicketReq req) {
		//判斷信箱有沒有註冊過了
//		  Player emailFind = playerdao.findByEmail(req.getPlayer().getEmail());
//		  if(emailFind!=null) {
//			  return new BuyTicketRes(null,RtnCode.EMAIL_EXIST);
//		  }
		  UUID uuid = UUID.randomUUID();
		  String uuidString = uuid.toString();
		  Player player = req.getPlayer();
		  player.setUuid(uuidString);
		  playerdao.save(player);
		  
		return new BuyTicketRes(uuidString,RtnCode.SUCCESSFUL);
	}


	//玩家票卷登入
	@Override
	public PlayerLoginRes playerLogin(String uuid) {
		Optional<Player> playerOp = playerdao.findById(uuid);
		if(playerOp.isEmpty()) {
			return new PlayerLoginRes(null,RtnCode.PLAYER_NO_EXIST);
		}
		LocalDate now = LocalDate.now();
		System.out.println(playerOp.get().getPlayDate());
		if(playerOp.get().getPlayDate().equals(now)){
			return new PlayerLoginRes(playerOp.get(),RtnCode.SUCCESSFUL);
		}	
		return new PlayerLoginRes(null,RtnCode.PLAYDATE_IS_NOT_ALREADY);
	}
	
	
	

}
