package org.example.controller;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 03/03/2023 14:07
Last Modified on 03/03/2023 14:07
Version 1.0
*/

import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.handler.ResponseHandler;
import org.example.model.Car;
import org.example.model.CreditProtection;
import org.example.services.CarService;
import org.example.services.CpService;
import org.example.utils.ConstantMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CpController {

    @Getter
    private CpService cpService;

    public CpController(){
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public CpController(CpService cpService){
        this.cpService = cpService;
    }

    @PostMapping("/v1/save/cp")
    public ResponseEntity<Object>
    saveCp(@RequestBody CreditProtection creditProtection) throws Exception {
        cpService.saveCP(creditProtection);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,creditProtection,null,null);
    }

    @GetMapping("/v1/cp/all")
    public ResponseEntity<List<CreditProtection>> getfindAll() {
        try {
            List<CreditProtection> lsCP = cpService.findAll();
            if (lsCP.isEmpty()) {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
            }
            return new ResponseEntity<>(lsCP, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/v1/cp/rate/{tahun}")
    public ResponseEntity<Object> getRateCPByTahun(@PathVariable("tahun") Integer tahun)throws Exception{

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,cpService.findRateCPByTahun(tahun),null,null);
    }
}
