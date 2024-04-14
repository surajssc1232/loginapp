package com.example.loginapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginapp.model.userEntity;
import com.example.loginapp.repository.userRepo;

import lombok.Data;

@Data
@Service
public class userService {
    @Autowired
    private userRepo userRepository;

    public boolean isUserAuthenticated(String username , String password){
        userEntity User = userRepository.findByUsername(username);
        if(User!=null && User.getPassword().equals(password)){
                    return true;
        }
        else{
            return false;
        }
    }

    public void save(userEntity User){
        userRepository.save(User);
    }


}
