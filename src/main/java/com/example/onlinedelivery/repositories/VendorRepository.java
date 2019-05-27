package com.example.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinedelivery.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer>{

}
