package com.example.parkview.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.parkview.entity.AdminUser;

@Repository
public interface AdminUserDao extends JpaRepository<AdminUser, String> {



//	//��s�]�I
	@Modifying
	@Transactional
	@Query(value="UPDATE park.adminuser "
			+ " SET account = :account , password = :pwd , manage_place =  :managePlace , "
			+ " manage_num = :manageNum "
			+ " WHERE account =  :oldaccount ",nativeQuery = true)
	public void updateAdminUser(
			@Param("account") String account,//
			@Param("oldaccount") String oldaccount,//
			@Param("pwd") String pwd,//
			@Param("managePlace") String managePlace,//
			@Param("manageNum") int manageNum);//
	
	
	
	//�e�ݭn�ӧR���ϥΪ�
		@Modifying
		@Transactional
		@Query(value="DELETE FROM park.adminuser WHERE account = :account",nativeQuery = true)
	public void deleteAdminUser(
			@Param("account") String account);
	
	
	
	
	//�e�ݺ޲z�H��-�T�ӱ���h�M��H��
		@Query(value=" select * from park.adminuser "
				+ " WHERE account LIKE %:account% and manage_place LIKE %:place% "
				+ " and manage_num = :position ",nativeQuery = true)
	public List<AdminUser> searchAdminuser(
			@Param("account") String account,//
			@Param("place") String place,//
			@Param("position") int position);//
		
		
		//�e�ݺ޲z�H��-��ӱ���h�M��H��
		@Query(value=" select * from park.adminuser "
				+ " WHERE account LIKE %:account% and manage_place LIKE %:place% ",nativeQuery = true)
	public List<AdminUser> searchAdminuserByTwo(
			@Param("account") String account,//
			@Param("place") String place);//
}
