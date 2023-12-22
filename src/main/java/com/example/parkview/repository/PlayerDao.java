package com.example.parkview.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.parkview.entity.AdminUser;
import com.example.parkview.entity.Player;

public interface PlayerDao extends JpaRepository<Player, String> {
	
	public Player findByEmail(String email);
	
	//§Ñ°O²¼¨÷±b¸¹
	@Query(value=" SELECT * FROM park.player "
			+ " where email = :email and play_date = :playDate ",nativeQuery = true)
	public List<Player> forgetQrcode(
			@Param("email") String email,
			@Param("playDate") LocalDate playDate);
}
