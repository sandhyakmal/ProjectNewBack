package org.example.controller;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 02/03/2023 17:07
Last Modified on 02/03/2023 17:07
Version 1.0
*/

import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.handler.ResponseHandler;
import org.example.model.RateAsuransi;
import org.example.model.Wilayah;
import org.example.services.RateService;
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
public class RateController {

    @Getter
    private RateService rateService;

    public RateController(){
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public RateController(RateService rateService){
        this.rateService = rateService;
    }

    @PostMapping("/v1/save/rate")
    public ResponseEntity<Object>
    saveRate(@RequestBody RateAsuransi rateAsuransi) throws Exception {
        rateService.saveRate(rateAsuransi);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,rateAsuransi,null,null);
    }

    @GetMapping("/v1/rate/all")
    public ResponseEntity<List<RateAsuransi>> getfindAll() {
        try {
            List<RateAsuransi> lsAsuransi = rateService.findAll();
            if (lsAsuransi.isEmpty()) {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
            }
            return new ResponseEntity<>(lsAsuransi, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("v1/rate/bat")
    public ResponseEntity<Object>
    saveAllRate(@Valid @RequestBody List<RateAsuransi> lsRate) throws Exception {

        if(lsRate==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        rateService.saveAllRate(lsRate);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    @GetMapping("/v1/rate/asuransi")
    public ResponseEntity<Object> getCarRate(@RequestParam("kodeWilayah") String kodeWilayah,
                                             @RequestParam("Otr")Integer Otr){
//        return carService.findByNamaMobil(namaMobil, brandId, wilayahId);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,rateService.findRateAsuransiByWilayahAndRangeToAndRangeFrom(kodeWilayah, Otr),null,null);

    }
}
