package com.example.parkview.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.parkview.entity.ReserveFacility;
import com.example.parkview.vo.BasicRes;
import com.example.parkview.vo.PlayerFacilityVo;

public interface ReserveFacilityDao extends JpaRepository<ReserveFacility,Integer> {
	
	public List<ReserveFacility> findByUuid(String uuid);
	
	//尋找此人預訂的遊樂園項目
	@Query(value="select * from park.facilityreserve "
			+ " WHERE uuid = :uuid  ",nativeQuery = true)
	public List<ReserveFacility> searchReserveFacility(
			@Param("uuid") String uuid);
	
	
	
	//刪除此人預訂的遊樂園項目
	@Modifying
	@Transactional
	@Query(value="DELETE FROM park.facilityreserve "
			+" WHERE facility_name = :facilityName and uuid = :uuid ",nativeQuery = true)
	public void deleteReserveFacility(
			@Param("uuid") String uuid,
			@Param("facilityName") String facilityName);
	

	@Query("select new com.example.parkview.vo.PlayerFacilityVo( "
	+" rf.id, rf.facilityName, rf.uuid, rf.facilityPlace, rf.age, fa.photo ) "
	+" from ReserveFacility as rf join Facility as fa on rf.facilityName = fa.name"
	+" where rf.uuid = :uuid ")
	public List<PlayerFacilityVo> searchReserve(@Param("uuid") String uuid);
	
	
	
	
}
