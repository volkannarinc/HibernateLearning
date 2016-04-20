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
@Table(name="CALISANLAR") //Veritabani TAblo adi
public class Personel implements Serializable {
	
	@Id
	@Column(name = "PERSONELID")	//Veritaban� Kolon Ad�
	private int personelId;
	
	@Basic	//alan�nnull de�er al�p almad���n�n kontrol�n� sa�lar.
	private String personelAdi;	//Bu alan mutlaka veritaban�nda olacak.
	
	@Transient	//Bir alan�n haritalanmas�n� g�rmezden gelir.
	private String personelSoyadi;	//Veritaban�nda soyad� de�eri olmayacak.
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
