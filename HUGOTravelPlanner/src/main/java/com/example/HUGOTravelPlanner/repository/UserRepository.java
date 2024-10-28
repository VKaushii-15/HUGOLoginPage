package com.example.HUGOTravelPlanner.repository;

import com.example.HUGOTravelPlanner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query(value = "INSERT IGNORE INTO user_details (username, phone_number, email) VALUES (:username, :phoneNumber, :email)", nativeQuery = true)
    void insertIgnoreUser(@Param("username") String username, @Param("phoneNumber") String phoneNumber, @Param("email") String email);
    
}
