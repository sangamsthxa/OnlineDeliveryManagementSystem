package com.example.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.onlinedelivery.model.ClientPost;

public interface ClientPostRepository extends JpaRepository<ClientPost, Integer> {

}
