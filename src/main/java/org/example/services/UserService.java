package org.example.services;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 07/03/2023 10:54
Last Modified on 07/03/2023 10:54
Version 1.0
*/

import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.model.Users;
import org.example.repos.UserRepo;
import org.example.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Getter
    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){this.userRepo = userRepo;}

    public Object loginUser(Users users) throws Exception{

        Users user = userRepo.findByUsername(users.getUsername()).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL));
        if(user != null){
            if (user.getPassword().equals(users.getPassword())){
                return user;
            }
            else{
                throw  new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL);
            }
        }else{
            throw  new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL);
        }
    }
}
