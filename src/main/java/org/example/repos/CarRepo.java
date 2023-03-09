package org.example.repos;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 28/02/2023 10:20
Last Modified on 28/02/2023 10:20
Version 1.0
*/

import org.example.model.Brands;
import org.example.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CarRepo extends JpaRepository<Car, Long> {

    @Query(value = "SELECT * FROM Car WHERE BrandId =:brandId " , nativeQuery = true)
    @Modifying
    List<Car> findByCarBrands(@Param("brandId") Long brandId);

    @Query(value = "SELECT * FROM Car WHERE NamaMobil =:namaMobil AND BrandId = :brandId AND WilayahId =:wilayahId" , nativeQuery = true)
//    @Modifying
    Optional<Car> findByCarName(@Param("namaMobil") String namaMobil,@Param("brandId") Long brandId, @Param("wilayahId") Long wilayahId);

    @Query(value = "SELECT * FROM Car WHERE BrandId = :brandId AND WilayahId =:wilayahId" , nativeQuery = true)
    List<Car> findCarByWilayahAndBrands(Long brandId, Long wilayahId);

}
