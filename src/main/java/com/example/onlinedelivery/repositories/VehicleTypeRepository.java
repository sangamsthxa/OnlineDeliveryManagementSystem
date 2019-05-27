package com.example.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinedelivery.model.VehicleType;


@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer>{

}
