package org.example.controller;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 06/03/2023 17:24
Last Modified on 06/03/2023 17:24
Version 1.0
*/

import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.handler.ResponseHandler;
import org.example.model.Brands;
import org.example.model.Pengajuan;
import org.example.services.BrandService;
import org.example.services.PengajuanService;
import org.example.utils.ConstantMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PengajuanController {

    @Getter
    private PengajuanService pengajuanService;

    public PengajuanController(){
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public PengajuanController(PengajuanService pengajuanService){
        this.pengajuanService = pengajuanService;
    }

    @PostMapping("/v1/save/pengajuan")
    public ResponseEntity<Object>
    savePengajuan(@RequestBody Pengajuan pengajuan) throws Exception {
        pengajuanService.savePengajuan(pengajuan);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,pengajuan,null,null);
    }

    @GetMapping("/v1/pengajuan/all")
    public ResponseEntity<List<Pengajuan>> getfindAll() {
        try {
            List<Pengajuan> lsPengajuan = pengajuanService.findAll();
            if (lsPengajuan.isEmpty()) {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
            }
            return new ResponseEntity<>(lsPengajuan, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/v1/pengajuan/tglpengajuan")
    public ResponseEntity<List<Pengajuan>> getAllbyCreatedDate() {
        try {
            List<Pengajuan> lsPengajuan = pengajuanService.findAllByCreatedDate();
            if (lsPengajuan.isEmpty()) {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
            }
            return new ResponseEntity<>(lsPengajuan, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
