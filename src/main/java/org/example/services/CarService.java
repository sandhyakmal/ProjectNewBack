package org.example.services;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 28/02/2023 10:21
Last Modified on 28/02/2023 10:21
Version 1.0
*/

import lombok.Getter;
import org.example.model.Car;
import org.example.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Getter
    private CarRepo carRepo;

    @Autowired
    public CarService(CarRepo carRepo){this.carRepo = carRepo;}

    public void saveCar(Car car) throws Exception{
        carRepo.save(car);
    }

    public List<Car> findAll()
    {
        return carRepo.findAll();
    }

    public List<Car> findByCarBrand(Long brandId)
    {
        return carRepo.findByCarBrands(brandId);
    }

    public List<Car> findByCarWilayahAndBrand(Long brandId, Long wilayahId)
    {
        return carRepo.findCarByWilayahAndBrands(brandId, wilayahId);
    }

    public Optional<Car> findByNamaMobil(String namaMobil, Long brandId, Long wilayahId)
    {
        return carRepo.findByCarName(namaMobil, brandId, wilayahId);
    }


}
