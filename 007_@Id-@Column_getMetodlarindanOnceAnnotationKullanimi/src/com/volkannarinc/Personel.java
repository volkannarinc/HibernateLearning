package com.volkannarinc;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personel
 *
 */
@Entity(name = "PERSONEL_TABLOSU")	//veritabaný tablo adý

public class Personel implements Serializable {

	private int personelId;
	private String personelAdi;
	private String personelSoyadi;
	private static final long serialVersionUID = 1L;

	public Personel() {
		super();
	}   
	
	@Id
	@Column(name = "PERSONELID")	//Veritabaný Kolon Adý
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
   
}
