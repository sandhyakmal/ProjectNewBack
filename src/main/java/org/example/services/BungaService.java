package org.example.services;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 03/03/2023 13:24
Last Modified on 03/03/2023 13:24
Version 1.0
*/

import lombok.Getter;
import org.example.model.Brands;
import org.example.model.Bunga;
import org.example.model.RateAsuransi;
import org.example.repos.BrandRepo;
import org.example.repos.BungaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BungaService {

    @Getter
    private BungaRepo bungaRepo;

    @Autowired
    public BungaService(BungaRepo bungaRepo){this.bungaRepo = bungaRepo;}

    public void saveBunga(Bunga bunga) throws Exception{
        bungaRepo.save(bunga);
    }

    public List<Bunga> findAll()
    {
        return bungaRepo.findAll();
    }

    public Optional<Bunga> findBungaByTahunAndTahunAtasAndTahunBawah(Integer Tenor, Integer Tahun)
    {
        return bungaRepo.findBungaByTahunAndTahunAtasAndTahunBawah(Tenor, Tahun);
    }
}
