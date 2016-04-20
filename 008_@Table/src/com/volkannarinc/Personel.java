package com.volkannarinc;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personel
 *
 */
@Entity(name = "PERSONEL_TABLOSU")	//veritaban� tablo ad�
@Table(name="CALISANLAR") //Veritabani TAblo adi
public class Personel implements Serializable {
	
	@Id
	@Column(name = "PERSONELID")	//Veritaban� Kolon Ad�
	private int personelId;
	
	@Column(name = "PERSONELADI")
	private String personelAdi;
	private String personelSoyadi;
	private Date personelKayitTarihi;
	private String PersonelAdresi;

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
		return "getPersonelAdi Metodundan gelen Veri --> " + this.personelAdi;
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
