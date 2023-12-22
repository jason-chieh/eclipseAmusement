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
	
	
	//�]�I�w��--
	@Modifying
	@Transactional
	@Query(value=" UPDATE park.facility "
			+ " SET reserve_num = reserve_num - 1 "
			+ " WHERE name = :facilityname  ",nativeQuery = true)
	public void chanelreserveFacility(
			@Param("facilityname") String facilityname);
	
	//�]�I�w��++
	@Modifying
	@Transactional
	@Query(value=" UPDATE park.facility "
			+ " SET reserve_num = reserve_num + 1 "
			+ " WHERE name = :facilityname  ",nativeQuery = true)
	public void reserveFacility(
			@Param("facilityname") String facilityname);
	
	
	
	//��s�]�I
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
	
	
	//�e�ݭn�ӧR���]�I
	@Modifying
	@Transactional
	@Query(value="DELETE FROM park.facility WHERE name = :name",nativeQuery = true)
	public void  deleteFacility(@Param("name") String name);
	
	//�e�ݺ޲z�]�I-�T�ӱ���h�M��
	@Query(value="select * from park.facility"
			+ " WHERE name like %:name%  "
			+ "  AND place like %:place%   "
			+ "  AND published = :published  ",nativeQuery = true)
	public List<Facility> searchThreeCondition(
			@Param("name") String name,//
			@Param("place") String place,//
			@Param("published") boolean published);//
	
	
	//�e�ݺ޲z�]�I-��ӭӱ���h�M��    �]���ڪ��D���L�i���i�H�a��
	@Query(value="select * from park.facility"
			+" WHERE name like %:name%  "
			+"  AND place like %:place%   ",nativeQuery = true)
	public List<Facility> searchTwoCondition(
			@Param("name") String name,//
			@Param("place") String place);//
	

	//�e�ݥu�|�X�{�}�񤤪��]�I
	@Query(value="select * from park.facility"
			+" where published is true ",nativeQuery = true)
	public List<Facility> searchFacilityIsPublished();
	
	//��ݥi�H���X�������
	@Query(value="SELECT * FROM park.facility",nativeQuery = true)
	public List<Facility> searchFacilityAll();
}
