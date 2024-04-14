package com.example.loginapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.loginapp.model.userEntity;
import com.example.loginapp.service.userService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class MainController {
    
    @Autowired
    userService userService;


    @GetMapping("/")
    public String signup(userEntity UserEntity){
        return "signupPage";
    }

    @PostMapping("/signup")
    public String postSignup(userEntity UserEntity){
        userService.save(UserEntity);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(userEntity UserEntity){
        return "loginPage";
    }

    @PostMapping("/login")
    public String postLogin(userEntity UserEntity){ {
        if(userService.isUserAuthenticated(UserEntity.getUsername(), UserEntity.getPassword())){
            return "LoginSuccess";
        }
        else{
            return "LoginFailed";
        }
    }
    
    



}
}
