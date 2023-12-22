package com.example.parkview.vo;

import java.util.ArrayList;
import java.util.List;

import com.example.parkview.constants.RtnCode;
import com.example.parkview.entity.Player;

public class ForgetTicketRes {

	private List<Player> playerlist = new ArrayList<>();
	
	private RtnCode rtncode;

	public ForgetTicketRes(List<Player> playerlist, RtnCode rtncode) {
		super();
		this.playerlist = playerlist;
		this.rtncode = rtncode;
	}

	public List<Player> getPlayerlist() {
		return playerlist;
	}

	public void setPlayerlist(List<Player> playerlist) {
		this.playerlist = playerlist;
	}

	public RtnCode getRtncode() {
		return rtncode;
	}

	public void setRtncode(RtnCode rtncode) {
		this.rtncode = rtncode;
	}

	
	
	
}
