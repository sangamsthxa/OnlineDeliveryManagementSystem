package com.example.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinedelivery.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
