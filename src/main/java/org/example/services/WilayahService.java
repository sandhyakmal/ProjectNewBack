package org.example.services;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 01/03/2023 11:21
Last Modified on 01/03/2023 11:21
Version 1.0
*/

import lombok.Getter;
import org.example.model.Brands;
import org.example.model.Wilayah;
import org.example.repos.BrandRepo;
import org.example.repos.WilayahRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WilayahService {

    @Getter
    private WilayahRepo wilayahRepo;

    @Autowired
    public WilayahService(WilayahRepo wilayahRepo){this.wilayahRepo = wilayahRepo;}

    public void saveWilayah(Wilayah wilayah) throws Exception{
        wilayahRepo.save(wilayah);
    }

    public List<Wilayah> findAll()
    {
        return wilayahRepo.findAll();
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllWilayah(List<Wilayah> ls){
        wilayahRepo.saveAll(ls);
    }
}
