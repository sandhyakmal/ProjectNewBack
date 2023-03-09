package org.example.services;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 03/03/2023 14:04
Last Modified on 03/03/2023 14:04
Version 1.0
*/

import lombok.Getter;
import org.example.model.Bunga;
import org.example.model.Car;
import org.example.model.CreditProtection;
import org.example.repos.BungaRepo;
import org.example.repos.CpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CpService {
    @Getter
    private CpRepo cpRepo;

    @Autowired
    public CpService(CpRepo cpRepo){this.cpRepo = cpRepo;}

    public void saveCP(CreditProtection creditProtection) throws Exception{
        cpRepo.save(creditProtection);
    }

    public List<CreditProtection> findAll()
    {
        return cpRepo.findAll();
    }

    public Optional<CreditProtection> findRateCPByTahun(Integer tahun)
    {
        return cpRepo.findRateCPByTahun(tahun);
    }
}
