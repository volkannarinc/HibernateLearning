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
@Table(name="personeltablosu") //VERÝTABANI TABLO ADI
public class Personel implements Serializable {
	//--------------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	//OTOTMATÝK ID DEÐERÝ
	private int personelId;
	private String personelAdi;	
	private String personelSoyadi;	
	private Date personelKayitTarihi;

	@OneToMany
	@JoinTable(name="PERSONEL_MESLEK",
				joinColumns=@JoinColumn(name="PERSONEL_ID"),
				inverseJoinColumns=@JoinColumn(name="MESLEK_ID"))
	private Collection<Meslek> meslek = new ArrayList<Meslek>();
	//--------------------------------------------------------------------
	
	public int getPersonelId() {
		return this.personelId;
	}

	public Collection<Meslek> getMeslek() {
		return meslek;
	}

	public void setMeslek(Collection<Meslek> meslek) {
		this.meslek = meslek;
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
