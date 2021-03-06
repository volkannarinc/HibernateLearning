package com.volkannarinc;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personel
 *
 */
@Entity(name = "PERSONEL_TABLOSU")	//veritabanư tablo adư

public class Personel implements Serializable {

	   
	@Id
	@Column(name = "PERSONELID")	//Veritabanư Kolon Adư
	private int personelId;
	@Column(name = "PERSONELADI")
	private String personelAdi;
	private String personelSoyadi;
	private static final long serialVersionUID = 1L;

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
   
}
