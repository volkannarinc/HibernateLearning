package com.volkannarinc;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personel
 *
 */
@Entity
@Table(name="Personel") //VERÝTABANI TABLO ADI
@SecondaryTable(name = "PersonelDetay")	//NORMALDE BÝR VALRIK SINIFI SADECE BÝR TABLOYA HARÝTALANIR.
										//EÐER BÝR VARLIK SINIFININ ALANLARINI FARKLI ÝKÝ TABLOYA 
										//AYIRMAK ÝSTERSEK O ZAMAN @SecondaryTable DÝPNOTUNU KULANIYORUZ.
public class Personel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int personelId;
	
	//@Column(name = "PERSONELADI")
	private String personelAdi;	
	private String personelSoyadi;	
	
	@Column(table ="PersonelDetay")
	private Date personelKayitTarihi;
	
	@Column(name="Adres",table ="PersonelDetay")
	private String PersonelAdresi;

	@Column(name="Maas",table ="PersonelDetay")
	private String PersonelMaasi;
	
	@Column(table ="PersonelDetay")
	private String PersonelTelefonu;

	public Personel() {
		super();
	}   
	

	public int getPersonelId() {
		return this.personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}   
	
	public String getPersonelAdi() {
		return this.personelAdi;
	}

	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}   
	public String getPersonelSoyadi() {
		return this.personelSoyadi;
	}

	public void setPersonelSoyadi(String personelSoyadi) {
		this.personelSoyadi = personelSoyadi;
	}


	public Date getPersonelKayitTarihi() {
		return personelKayitTarihi;
	}


	public void setPersonelKayitTarihi(Date personelKayitTarihi) {
		this.personelKayitTarihi = personelKayitTarihi;
	}


	public String getPersonelAdresi() {
		return PersonelAdresi;
	}


	public void setPersonelAdresi(String personelAdresi) {
		PersonelAdresi = personelAdresi;
	}


	public String getPersonelMaasi() {
		return PersonelMaasi;
	}


	public void setPersonelMaasi(String personelMaasi) {
		PersonelMaasi = personelMaasi;
	}


	public String getPersonelTelefonu() {
		return PersonelTelefonu;
	}


	public void setPersonelTelefonu(String personelTelefonu) {
		PersonelTelefonu = personelTelefonu;
	}
	
	
   
}
