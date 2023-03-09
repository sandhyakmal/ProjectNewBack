package org.example.repos;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 28/02/2023 10:03
Last Modified on 28/02/2023 10:03
Version 1.0
*/

import org.example.model.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brands, Long> {

}
