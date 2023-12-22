package com.example.parkview.vo;

import com.example.parkview.constants.RtnCode;
import com.example.parkview.entity.Player;

public class PlayerLoginRes {
	
	private Player player ;
	
	private RtnCode rtncode;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public RtnCode getRtncode() {
		return rtncode;
	}

	public void setRtncode(RtnCode rtncode) {
		this.rtncode = rtncode;
	}

	public PlayerLoginRes(Player player, RtnCode rtncode) {
		super();
		this.player = player;
		this.rtncode = rtncode;
	}
	
	
	
}
