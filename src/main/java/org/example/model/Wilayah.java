package org.example.model;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 01/03/2023 11:17
Last Modified on 01/03/2023 11:17
Version 1.0
*/

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Wilayah")
public class Wilayah implements Serializable {

    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "NamaProvinsi")
    private String namaProvinsi;

    @Column(name = "KodeWilayah")
    private String kodeWilayah;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    public String getKodeWilayah() {
        return kodeWilayah;
    }

    public void setKodeWilayah(String kodeWilayah) {
        this.kodeWilayah = kodeWilayah;
    }
}
