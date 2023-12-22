package com.example.parkview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.parkview.entity.ParkingLot;

public interface ParkingLotDao extends JpaRepository<ParkingLot, String>{

}
