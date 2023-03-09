package org.example.controller;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 07/03/2023 10:55
Last Modified on 07/03/2023 10:55
Version 1.0
*/

import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.handler.ResponseHandler;
import org.example.model.Users;
import org.example.services.UserService;
import org.example.utils.ConstantMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
public class UserController {

    @Getter
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/v1/login")
    public ResponseEntity<Object> userLogin(@Valid @RequestBody Users users) throws Exception {
        if(users==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_LOGIN,
                HttpStatus.CREATED, userService.loginUser(users),null,null);
    }
}
