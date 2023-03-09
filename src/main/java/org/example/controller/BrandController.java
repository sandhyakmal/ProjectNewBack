package org.example.controller;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 28/02/2023 10:05
Last Modified on 28/02/2023 10:05
Version 1.0
*/

import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.handler.ResponseHandler;
import org.example.model.Brands;
import org.example.services.BrandService;
import org.example.utils.ConstantMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class BrandController {

    @Getter
    private BrandService brandService;

    public BrandController(){
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public BrandController(BrandService brandService){
        this.brandService = brandService;
    }

    @PostMapping("/v1/save/brand")
    public ResponseEntity<Object>
    saveBrand(@RequestBody Brands brands) throws Exception {
        brandService.saveBrand(brands);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,brands,null,null);
    }

    @GetMapping("/v1/brand/all")
    public ResponseEntity<List<Brands>> getfindAll() {
        try {
            List<Brands> lsBrands = brandService.findAll();
            if (lsBrands.isEmpty()) {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
            }
            return new ResponseEntity<>(lsBrands, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
