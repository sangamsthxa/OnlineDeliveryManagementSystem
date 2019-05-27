package com.example.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinedelivery.model.DeliveryService;
@Repository
public interface DeliveryServiceRepository extends JpaRepository<DeliveryService, Integer>{

}
