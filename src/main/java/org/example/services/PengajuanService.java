package org.example.services;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 06/03/2023 16:51
Last Modified on 06/03/2023 16:51
Version 1.0
*/

import lombok.Getter;
import org.example.model.Brands;
import org.example.model.Pengajuan;
import org.example.repos.BrandRepo;
import org.example.repos.PengajuanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PengajuanService {
    @Getter
    private PengajuanRepo pengajuanRepo;

    @Autowired
    public PengajuanService(PengajuanRepo pengajuanRepo){this.pengajuanRepo = pengajuanRepo;}

    public void savePengajuan(Pengajuan pengajuan) throws Exception{
        if(pengajuan.getNoKontrak().isEmpty() && pengajuan.getNoPin().isEmpty()){
            pengajuan.setNoKontrak("-");
            pengajuan.setNoPin("-");
            pengajuanRepo.save(pengajuan);
        } else if (pengajuan.getNama().isEmpty() && pengajuan.getAlamat().isEmpty() && pengajuan.getNoHp().isEmpty()){
            pengajuan.setNama("-");
            pengajuan.setAlamat("-");
            pengajuan.setNoHp("-");
            pengajuanRepo.save(pengajuan);
        } else {
            pengajuanRepo.save(pengajuan);
        }
    }

    public List<Pengajuan> findAll()
    {
        return pengajuanRepo.findAll();
    }

    public List<Pengajuan> findAllByCreatedDate (){
        LocalDate today = LocalDate.now();
        List<Pengajuan>  lsPengajaun = pengajuanRepo.findAllByCreatedDate(today);
        return lsPengajaun;
    }
}
