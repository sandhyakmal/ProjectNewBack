package org.example.model;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 13/03/2023 13:36
Last Modified on 13/03/2023 13:36
Version 1.0
*/

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Fidusia")
public class Fidusia implements Serializable {

    private static final long serialversionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "PHAtas")
    private Long phAtas;

    @Column(name = "PHBawah")
    private Long phBawah;

    @Column(name = "TotalFidusia")
    private Long totalFidusia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhAtas() {
        return phAtas;
    }

    public void setPhAtas(Long phAtas) {
        this.phAtas = phAtas;
    }

    public Long getPhBawah() {
        return phBawah;
    }

    public void setPhBawah(Long phBawah) {
        this.phBawah = phBawah;
    }

    public Long getTotalFidusia() {
        return totalFidusia;
    }

    public void setTotalFidusia(Long totalFidusia) {
        this.totalFidusia = totalFidusia;
    }
}
