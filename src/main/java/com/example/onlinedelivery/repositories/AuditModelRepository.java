package com.example.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinedelivery.model.AuditModel;

@Repository
public interface AuditModelRepository extends JpaRepository<AuditModel, Integer>{

}
