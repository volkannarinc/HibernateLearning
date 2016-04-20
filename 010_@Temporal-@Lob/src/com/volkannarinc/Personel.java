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
@Table(name="CALISANLAR") //VER�TABANI TABLO ADI
public class Personel implements Serializable {
	
	@Id
	@Column(name = "PERSONELID")	//VER�TABANI KOLON ADI
	private int personelId;
	
	//@Column(name = "PERSONELADI")
	private String personelAdi;	
	private String personelSoyadi;	
	
	@Temporal(TemporalType.DATE)	//ZAMANSAL DE�ERLER�N VER�LMES� ���N KULLANILIR.G�R�LEN ZAMANI FORMATLADIK.
	private Date personelKayitTarihi;	//G�R�LEN TAR�H�N FORMATINDAN SAAT� �IKARDIK.
	
	@Lob	//�OK B�Y�K VER�LER� TUTACAK ALANLARI BEL�RT�R. VER� �OK B�Y�KSE , HAR�TALANMA SIRASINDA B�Y�K B�R VER� T�R�YLE E�LE�T�R�R.
	private String PersonelAdresi; //LARGE OBJE - GEN�� VER� ALANI T�R�

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
