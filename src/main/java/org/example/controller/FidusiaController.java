package org.example.controller;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 13/03/2023 14:16
Last Modified on 13/03/2023 14:16
Version 1.0
*/

import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.handler.ResponseHandler;
import org.example.model.Bunga;
import org.example.model.Fidusia;
import org.example.services.BungaService;
import org.example.services.FidusiaService;
import org.example.utils.ConstantMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class FidusiaController {

    @Getter
    private FidusiaService fidusiaService;

    public FidusiaController(){
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public FidusiaController(FidusiaService fidusiaService){
        this.fidusiaService = fidusiaService;
    }

    @PostMapping("/v1/save/fidusia")
    public ResponseEntity<Object>
    saveFidusia(@RequestBody Fidusia fidusia) throws Exception {
        fidusiaService.saveFidusia(fidusia);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,fidusia,null,null);
    }

    @GetMapping("/v1/fidusia/all")
    public ResponseEntity<List<Fidusia>> getfindAll() {
        try {
            List<Fidusia> lsFidusia = fidusiaService.findAll();
            if (lsFidusia.isEmpty()) {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
            }
            return new ResponseEntity<>(lsFidusia, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/v1/fidusia")
    public ResponseEntity<Object> getFidusia(@RequestParam("ph") Long ph){
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,fidusiaService.findFidusiaByPHAtasAndPHBawah(ph),null,null);

    }
}
