package org.example.model;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 03/03/2023 10:55
Last Modified on 03/03/2023 10:55
Version 1.0
*/

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Bunga")
public class Bunga implements Serializable {

    private static final long serialversionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "TahunAtas")
    private Integer tahunAtas;

    @Column(name = "TahunBawah")
    private Integer tahunBawah;

    @Column(name = "Tahun")
    private Integer tahun;

    @Column(name = "Bunga")
    private Double bunga;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTahunAtas() {
        return tahunAtas;
    }

    public void setTahunAtas(Integer tahunAtas) {
        this.tahunAtas = tahunAtas;
    }

    public Integer getTahunBawah() {
        return tahunBawah;
    }

    public void setTahunBawah(Integer tahunBawah) {
        this.tahunBawah = tahunBawah;
    }

    public Integer getTahun() {
        return tahun;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }

    public Double getBunga() {
        return bunga;
    }

    public void setBunga(Double bunga) {
        this.bunga = bunga;
    }
}
