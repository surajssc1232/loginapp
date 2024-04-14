package com.example.loginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginapp.model.userEntity;

@Repository
public interface userRepo extends JpaRepository<userEntity, Long>{

    userEntity findByUsername(String username);
    
}
