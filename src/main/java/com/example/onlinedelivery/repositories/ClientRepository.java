package com.example.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinedelivery.model.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
