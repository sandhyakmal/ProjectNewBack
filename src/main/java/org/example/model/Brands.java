package org.example.model;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 28/02/2023 9:50
Last Modified on 28/02/2023 9:50
Version 1.0
*/

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "Brand")
public class Brands implements Serializable {

    private static final long serialversionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;


    @Column(name = "BrandMobil",nullable = false)
    private String brandMobil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandMobil() {
        return brandMobil;
    }

    public void setBrandMobil(String brandMobil) {
        this.brandMobil = brandMobil;
    }
}
