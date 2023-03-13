package org.example.services;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 13/03/2023 14:14
Last Modified on 13/03/2023 14:14
Version 1.0
*/

import lombok.Getter;
import org.example.model.Bunga;
import org.example.model.Fidusia;
import org.example.repos.BungaRepo;
import org.example.repos.FidusiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FidusiaService {

    @Getter
    private FidusiaRepo fidusiaRepo;

    @Autowired
    public FidusiaService(FidusiaRepo fidusiaRepo){this.fidusiaRepo = fidusiaRepo;}

    public void saveFidusia(Fidusia fidusia) throws Exception{
        fidusiaRepo.save(fidusia);
    }

    public List<Fidusia> findAll()
    {
        return fidusiaRepo.findAll();
    }

    public Optional<Fidusia> findFidusiaByPHAtasAndPHBawah(Long ph)
    {
        return fidusiaRepo.findFidusiaByPHAtasAndPHBawah(ph);
    }
}
