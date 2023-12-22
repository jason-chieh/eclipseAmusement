package com.example.parkview.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.parkview.constants.RtnCode;
import com.example.parkview.entity.Facility;
import com.example.parkview.vo.BasicRes;


@Repository
public interface FacilityDao extends JpaRepository<Facility, String>{
	
	
	//設施預約--
	@Modifying
	@Transactional
	@Query(value=" UPDATE park.facility "
			+ " SET reserve_num = reserve_num - 1 "
			+ " WHERE name = :facilityname  ",nativeQuery = true)
	public void chanelreserveFacility(
			@Param("facilityname") String facilityname);
	
	//設施預約++
	@Modifying
	@Transactional
	@Query(value=" UPDATE park.facility "
			+ " SET reserve_num = reserve_num + 1 "
			+ " WHERE name = :facilityname  ",nativeQuery = true)
	public void reserveFacility(
			@Param("facilityname") String facilityname);
	
	
	
	//更新設施
	@Modifying
	@Transactional
	@Query(value="UPDATE park.facility "
			+ " SET name = :newname, description = :description, place =  :place, "
			+ " published = :published, photo = :photo, age = :age, "
			+ " start_Date = :startDate, end_Date = :endDate, photoS = :photoS "
			+ " WHERE name =  :oldname ",nativeQuery = true)
	public void updateFacility(
			@Param("newname") String newname,//
			@Param("oldname") String oldname,//
			@Param("description") String description,//
			@Param("place") String place,//
			@Param("published") boolean published,//
			@Param("photo") byte[] photo ,//
			@Param("age") int age,//
			@Param("startDate") LocalDate startDate,//
			@Param("endDate") LocalDate endDate,//
			@Param("photoS") String photoS);//
	
	
	//前端要來刪除設施
	@Modifying
	@Transactional
	@Query(value="DELETE FROM park.facility WHERE name = :name",nativeQuery = true)
	public void  deleteFacility(@Param("name") String name);
	
	//前端管理設施-三個條件去尋找
	@Query(value="select * from park.facility"
			+ " WHERE name like %:name%  "
			+ "  AND place like %:place%   "
			+ "  AND published = :published  ",nativeQuery = true)
	public List<Facility> searchThreeCondition(
			@Param("name") String name,//
			@Param("place") String place,//
			@Param("published") boolean published);//
	
	
	//前端管理設施-兩個個條件去尋找    因為我知道布林可不可以帶空
	@Query(value="select * from park.facility"
			+" WHERE name like %:name%  "
			+"  AND place like %:place%   ",nativeQuery = true)
	public List<Facility> searchTwoCondition(
			@Param("name") String name,//
			@Param("place") String place);//
	

	//前端只會出現開放中的設施
	@Query(value="select * from park.facility"
			+" where published is true ",nativeQuery = true)
	public List<Facility> searchFacilityIsPublished();
	
	//後端可以撈出全部資料
	@Query(value="SELECT * FROM park.facility",nativeQuery = true)
	public List<Facility> searchFacilityAll();
}
