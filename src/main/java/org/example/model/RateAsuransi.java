package org.example.model;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 02/03/2023 16:55
Last Modified on 02/03/2023 16:55
Version 1.0
*/

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RateAsuransi")
public class RateAsuransi implements Serializable {

    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;


    @Column(name = "Wilayah")
    private String wilayah;

    @Column(name = "RangeFrom", length = 13 )
    private Integer rangeFrom;

    @Column(name = "RangeTo", length = 13)
    private Integer rangeTo;

    @Column(name = "AllRisk")
    private Double allRisk;

    @Column(name = "TLO")
    private Double tlo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWilayah() {
        return wilayah;
    }

    public void setWilayah(String wilayah) {
        this.wilayah = wilayah;
    }

    public Integer getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(Integer rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public Integer getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(Integer rangeTo) {
        this.rangeTo = rangeTo;
    }

    public Double getAllRisk() {
        return allRisk;
    }

    public void setAllRisk(Double allRisk) {
        this.allRisk = allRisk;
    }

    public Double getTlo() {
        return tlo;
    }

    public void setTlo(Double tlo) {
        this.tlo = tlo;
    }
}
