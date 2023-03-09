package org.example.controller;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 28/02/2023 10:22
Last Modified on 28/02/2023 10:22
Version 1.0
*/

import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.handler.ResponseHandler;
import org.example.model.Car;
import org.example.services.CarService;
import org.example.utils.ConstantMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
public class CarController {

    @Getter
    private CarService carService;

    public CarController(){
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @PostMapping("/v1/save/car")
    public ResponseEntity<Object>
    saveCar(@RequestBody Car car) throws Exception {
        carService.saveCar(car);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,car,null,null);
    }

    @GetMapping("/v1/car/all")
    public ResponseEntity<List<Car>> getfindAll() {
        try {
            List<Car> lsCar = carService.findAll();
            if (lsCar.isEmpty()) {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
            }
            return new ResponseEntity<>(lsCar, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/v1/car/brands/{brandId}/{wilayahId}")
    public ResponseEntity<Object> getByCarWilayahAndBrand(@PathVariable("brandId") Long brandId,
                                                          @PathVariable("wilayahId") Long wilayahId)throws Exception{

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,carService.findByCarWilayahAndBrand(brandId, wilayahId),null,null);
    }

    @GetMapping("/v1/car/brands/{brandId}")
    public ResponseEntity<Object> getByCarBrands(@PathVariable("brandId") Long brandId)throws Exception{

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,carService.findByCarBrand(brandId),null,null);
    }

    @GetMapping("/v1/car/name")
    public ResponseEntity<Object> getCarName(@RequestParam("namaMobil") String namaMobil,
                               @RequestParam("brandId")Long brandId,
                               @RequestParam("wilayahId")Long wilayahId){
//        return carService.findByNamaMobil(namaMobil, brandId, wilayahId);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,carService.findByNamaMobil(namaMobil, brandId, wilayahId),null,null);

    }


}
