package com.example.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinedelivery.Map.LongLat;

public interface LongLatRepository extends JpaRepository<LongLat, Integer>{

}
