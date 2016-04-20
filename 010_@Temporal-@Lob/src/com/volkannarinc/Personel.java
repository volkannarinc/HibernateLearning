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
@Table(name="CALISANLAR") //VERÝTABANI TABLO ADI
public class Personel implements Serializable {
	
	@Id
	@Column(name = "PERSONELID")	//VERÝTABANI KOLON ADI
	private int personelId;
	
	//@Column(name = "PERSONELADI")
	private String personelAdi;	
	private String personelSoyadi;	
	
	@Temporal(TemporalType.DATE)	//ZAMANSAL DEÐERLERÝN VERÝLMESÝ ÝÇÝN KULLANILIR.GÝRÝLEN ZAMANI FORMATLADIK.
	private Date personelKayitTarihi;	//GÝRÝLEN TARÝHÝN FORMATINDAN SAATÝ ÇIKARDIK.
	
	@Lob	//ÇOK BÜYÜK VERÝLERÝ TUTACAK ALANLARI BELÝRTÝR. VERÝ ÇOK BÜYÜKSE , HARÝTALANMA SIRASINDA BÜYÜK BÝR VERÝ TÜRÜYLE EÞLEÞTÝRÝR.
	private String PersonelAdresi; //LARGE OBJE - GENÝÞ VERÝ ALANI TÜRÜ

	public Personel() {
		super();
	}   
	

	public int getPersonelId() {
		return this.personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}   
	
	@Column(name = "PERSONELADI")
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
	
	
   
}
