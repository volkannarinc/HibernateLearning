package com.volkannarinc.kurum;


import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personel
 *
 */
@Entity
@Table(name="PERSONEL") //VERÝTABANI TABLO ADI
public class Personel implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="PERSONEL_ID")
	private long personelId;
	
	@Column(name="PERSONEL_ADI",nullable=false,length=100)
	private String personelAdi;	
	
	@Embedded
	private Adres personelAdres;
	
	public Personel() {
		super();
	}
	
	public Personel(String personelAdi) {
		this.personelAdi = personelAdi;
	}   
	
	public Personel(String personelAdi,Adres personelAdres) {
		this.personelAdi = personelAdi;
		this.personelAdres = personelAdres;
	}

	public long getPersonelId() {
		return personelId;
	}

	public void setPersonelId(long personelId) {
		this.personelId = personelId;
	}

	public String getPersonelAdi() {
		return personelAdi;
	}

	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}

	public Adres getPersonelAdres() {
		return personelAdres;
	}

	public void setPersonelAdres(Adres personelAdres) {
		this.personelAdres = personelAdres;
	}  
	
	
	

	
   
}
