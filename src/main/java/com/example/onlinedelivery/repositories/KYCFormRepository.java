package com.example.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinedelivery.model.KYCForm;

@Repository
public interface KYCFormRepository extends JpaRepository<KYCForm, Integer>{

}
