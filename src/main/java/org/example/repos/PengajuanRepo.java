package org.example.repos;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 06/03/2023 16:51
Last Modified on 06/03/2023 16:51
Version 1.0
*/

import org.example.model.Pengajuan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PengajuanRepo extends JpaRepository<Pengajuan, Long> {

    @Query(value = "SELECT * FROM Pengajuan WHERE CreatedDate =:localDate " , nativeQuery = true)
    List<Pengajuan> findAllByCreatedDate(LocalDate localDate);
}
