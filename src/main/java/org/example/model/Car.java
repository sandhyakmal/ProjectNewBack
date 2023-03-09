package org.example.model;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 28/02/2023 10:12
Last Modified on 28/02/2023 10:12
Version 1.0
*/

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Car")
public class Car implements Serializable {

    private static final long serialversionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BrandId")
    private Brands brands;

    @ManyToOne
    @JoinColumn(name = "WilayahId")
    private Wilayah wilayah;

    @Column(name = "NamaMobil")
    private String namaMobil;

    @Column(name = "HargaMobil")
    private Integer hargaMobil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public Integer getHargaMobil() {
        return hargaMobil;
    }

    public void setHargaMobil(Integer hargaMobil) {
        this.hargaMobil = hargaMobil;
    }

    public Wilayah getWilayah() {
        return wilayah;
    }

    public void setWilayah(Wilayah wilayah) {
        this.wilayah = wilayah;
    }
}
