package org.example.repos;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 01/03/2023 11:21
Last Modified on 01/03/2023 11:21
Version 1.0
*/

import org.example.model.Wilayah;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WilayahRepo extends JpaRepository<Wilayah, Long> {
}
