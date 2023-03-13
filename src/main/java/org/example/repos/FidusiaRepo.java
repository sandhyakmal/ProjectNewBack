package org.example.repos;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 13/03/2023 13:55
Last Modified on 13/03/2023 13:55
Version 1.0
*/

import org.example.model.Bunga;
import org.example.model.Fidusia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FidusiaRepo extends JpaRepository<Fidusia, Long> {

    @Query(value = "SELECT * FROM Fidusia WHERE PHAtas >=:ph AND PHBawah <:ph" , nativeQuery = true)
    Optional<Fidusia> findFidusiaByPHAtasAndPHBawah(Long ph);
}
