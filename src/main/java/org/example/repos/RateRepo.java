package org.example.repos;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 02/03/2023 17:04
Last Modified on 02/03/2023 17:04
Version 1.0
*/

import org.example.model.Car;
import org.example.model.RateAsuransi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RateRepo extends JpaRepository<RateAsuransi, Long> {
    @Query(value = "SELECT * FROM RateAsuransi WHERE Wilayah=:kodeWilayah AND RangeTo >= :Otr AND RangeFrom <=:Otr" , nativeQuery = true)
    Optional<RateAsuransi> findRateAsuransiByWilayahAndRangeToAndRangeFrom(String kodeWilayah, Integer Otr);

}
