package com.volkannarinc;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personel
 *
 */
@Entity
@Table(name="PERSONEL") //VERÝTABANI TABLO ADI
public class Personel implements Serializable {
	//--------------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	//OTOTMATÝK ID DEÐERÝ
	private int personelId;
	private String personelAdi;	
	private String personelSoyadi;	
	private Date personelKayitTarihi;

	@ManyToMany
	private Collection<Meslek> mesleklistesi = new ArrayList<Meslek>();
	//--------------------------------------------------------------------
	
	public int getPersonelId() {
		return this.personelId;
	}

	public Collection<Meslek> getMeslekListesi() {
		return mesleklistesi;
	}

	public void setMeslekListesi(Collection<Meslek> mesleklistesi) {
		this.mesleklistesi = mesleklistesi;
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
	
   
}
