package org.example.model;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 06/03/2023 16:21
Last Modified on 06/03/2023 16:21
Version 1.0
*/

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Pengajuan")
public class Pengajuan implements Serializable {

    private static final long serialversionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "StatusKonsumen")
    private String statusKonsumen;

    @Column(name = "NoKontrak")
    private String noKontrak;

    @Column(name = "NoPin")
    private String noPin;

    @Column(name = "Nama")
    private String nama;

    @Column(name = "Alamat")
    private String alamat;

    @Column(name = "NoHandphone")
    private String noHp;

    @Column(name = "BrandMobil")
    private String brandMobil;

    @Column(name = "NamaMobil")
    private String namaMobil;

    @Column(name = "TahunMobil")
    private Integer tahunMobil;

    @Column(name = "Tenor")
    private Integer tenor;

    @Column(name = "OTR")
    private Integer otr;

    @Column(name = "Pencairan")
    private Integer pencairan;

    @Column(name = "Angsuran")
    private Integer angsuran;

    @Column(name = "CreatedDate",nullable = false)
    private LocalDate createdDate = LocalDate.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusKonsumen() {
        return statusKonsumen;
    }

    public void setStatusKonsumen(String statusKonsumen) {
        this.statusKonsumen = statusKonsumen;
    }

    public String getNoKontrak() {
        return noKontrak;
    }

    public void setNoKontrak(String noKontrak) {
        this.noKontrak = noKontrak;
    }

    public String getNoPin() {
        return noPin;
    }

    public void setNoPin(String noPin) {
        this.noPin = noPin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getBrandMobil() {
        return brandMobil;
    }

    public void setBrandMobil(String brandMobil) {
        this.brandMobil = brandMobil;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public Integer getTahunMobil() {
        return tahunMobil;
    }

    public void setTahunMobil(Integer tahunMobil) {
        this.tahunMobil = tahunMobil;
    }

    public Integer getTenor() {
        return tenor;
    }

    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }

    public Integer getOtr() {
        return otr;
    }

    public void setOtr(Integer otr) {
        this.otr = otr;
    }

    public Integer getPencairan() {
        return pencairan;
    }

    public void setPencairan(Integer pencairan) {
        this.pencairan = pencairan;
    }

    public Integer getAngsuran() {
        return angsuran;
    }

    public void setAngsuran(Integer angsuran) {
        this.angsuran = angsuran;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
