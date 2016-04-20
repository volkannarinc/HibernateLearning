package com.volkannarinc;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personel
 *
 */
@Entity
@Table(name="personeltablosu") //VERÝTABANI TABLO ADI
public class Personel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	//OTOTMATÝK ID DEÐERÝ
	private int personelId;
	private String personelAdi;	
	private String personelSoyadi;	
	
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
