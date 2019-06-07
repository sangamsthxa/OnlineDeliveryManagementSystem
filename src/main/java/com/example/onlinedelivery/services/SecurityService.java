package com.example.onlinedelivery.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}