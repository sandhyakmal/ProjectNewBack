package org.example.services;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 02/03/2023 17:05
Last Modified on 02/03/2023 17:05
Version 1.0
*/

import lombok.Getter;
import org.example.model.Car;
import org.example.model.RateAsuransi;
import org.example.model.Wilayah;
import org.example.repos.RateRepo;
import org.example.repos.WilayahRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RateService {

    @Getter
    private RateRepo rateRepo;

    @Autowired
    public RateService(RateRepo rateRepo){this.rateRepo = rateRepo;}

    public void saveRate(RateAsuransi rateAsuransi) throws Exception{
        rateRepo.save(rateAsuransi);
    }

    public List<RateAsuransi> findAll()
    {
        return rateRepo.findAll();
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllRate(List<RateAsuransi> ls){
        rateRepo.saveAll(ls);
    }

    public Optional<RateAsuransi> findRateAsuransiByWilayahAndRangeToAndRangeFrom(String kodeWilayah, Integer Otr)
    {
        return rateRepo.findRateAsuransiByWilayahAndRangeToAndRangeFrom(kodeWilayah, Otr);
    }
}
