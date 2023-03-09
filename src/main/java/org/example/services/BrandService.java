package org.example.services;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 28/02/2023 10:04
Last Modified on 28/02/2023 10:04
Version 1.0
*/

import lombok.Getter;
import org.example.model.Brands;
import org.example.repos.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Getter
    private BrandRepo brandRepo;

    @Autowired
    public BrandService(BrandRepo brandRepo){this.brandRepo = brandRepo;}

    public void saveBrand(Brands brands) throws Exception{
        brandRepo.save(brands);
    }

    public List<Brands> findAll()
    {
        return brandRepo.findAll();
    }
}
