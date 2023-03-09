package org.example.controller;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 01/03/2023 11:23
Last Modified on 01/03/2023 11:23
Version 1.0
*/

import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.handler.ResponseHandler;
import org.example.model.Brands;
import org.example.model.Wilayah;
import org.example.services.BrandService;
import org.example.services.WilayahService;
import org.example.utils.ConstantMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
public class WilayahController {

    @Getter
    private WilayahService wilayahService;

    public WilayahController(){
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public WilayahController(WilayahService wilayahService){
        this.wilayahService = wilayahService;
    }

    @PostMapping("/v1/save/wilayah")
    public ResponseEntity<Object>
    saveWilayah(@RequestBody Wilayah wilayah) throws Exception {
        wilayahService.saveWilayah(wilayah);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,wilayah,null,null);
    }

    @GetMapping("/v1/wilayah/all")
    public ResponseEntity<List<Wilayah>> getfindAll() {
        try {
            List<Wilayah> lsWilayah = wilayahService.findAll();
            if (lsWilayah.isEmpty()) {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
            }
            return new ResponseEntity<>(lsWilayah, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("v1/wilayah/bat")
    public ResponseEntity<Object>
    saveAllWilayah(@Valid @RequestBody List<Wilayah> listWilayah) throws Exception {

        if(listWilayah==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        wilayahService.saveAllWilayah(listWilayah);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }
}
