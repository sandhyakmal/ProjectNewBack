package org.example.controller;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 03/03/2023 13:29
Last Modified on 03/03/2023 13:29
Version 1.0
*/


import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.handler.ResponseHandler;
import org.example.model.Brands;
import org.example.model.Bunga;
import org.example.services.BrandService;
import org.example.services.BungaService;
import org.example.utils.ConstantMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class BungaController {

    @Getter
    private BungaService bungaService;

    public BungaController(){
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public BungaController(BungaService bungaService){
        this.bungaService = bungaService;
    }

    @PostMapping("/v1/save/bunga")
    public ResponseEntity<Object>
    saveBunga(@RequestBody Bunga bunga) throws Exception {
        bungaService.saveBunga(bunga);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,bunga,null,null);
    }

    @GetMapping("/v1/bunga/all")
    public ResponseEntity<List<Bunga>> getfindAll() {
        try {
            List<Bunga> lsBunga = bungaService.findAll();
            if (lsBunga.isEmpty()) {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
            }
            return new ResponseEntity<>(lsBunga, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/v1/bunga")
    public ResponseEntity<Object> getBunga(@RequestParam("Tenor") Integer Tenor,
                                           @RequestParam("Tahun") Integer Tahun){
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,bungaService.findBungaByTahunAndTahunAtasAndTahunBawah(Tenor, Tahun),null,null);

    }
}
