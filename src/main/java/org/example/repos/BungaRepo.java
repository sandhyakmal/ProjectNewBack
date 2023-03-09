package org.example.repos;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 03/03/2023 13:03
Last Modified on 03/03/2023 13:03
Version 1.0
*/

import org.example.model.Bunga;
import org.example.model.RateAsuransi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BungaRepo extends JpaRepository<Bunga, Long> {

    @Query(value = "SELECT * FROM Bunga WHERE Tahun =:Tenor AND TahunAtas >=:Tahun AND TahunBawah <=:Tahun" , nativeQuery = true)
    Optional<Bunga> findBungaByTahunAndTahunAtasAndTahunBawah(Integer Tenor, Integer Tahun);

}
