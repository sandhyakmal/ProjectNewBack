package org.example.repos;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 03/03/2023 14:02
Last Modified on 03/03/2023 14:02
Version 1.0
*/

import org.example.model.CreditProtection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CpRepo extends JpaRepository<CreditProtection, Long> {

    Optional<CreditProtection> findRateCPByTahun(Integer tenor);
}
