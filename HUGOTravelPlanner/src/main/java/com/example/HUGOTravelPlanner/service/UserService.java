package com.example.HUGOTravelPlanner.service;

import com.example.HUGOTravelPlanner.model.User;
import com.example.HUGOTravelPlanner.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Transactional
    public void saveUser(String username , String phoneNumber , String email ) {
        try {
            userRepository.insertIgnoreUser(username,phoneNumber,email);
        } catch (Exception e) {
            System.out.println("Error saving user: " + e);
        }
    }
}