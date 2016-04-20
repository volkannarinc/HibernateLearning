package com.volkannarinc;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MESLEK")
public class Meslek {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int meslekId;
	private String meslekAdi;
	
	@ManyToMany(mappedBy="mesleklistesi")//hakim olan tarafý belirttik.
	private Collection<Personel> personelistesi = new ArrayList<Personel>();
	
	public Collection<Personel> getPersoneListesi() {
		return personelistesi;
	}

	public void setPersonelListesi(Collection<Personel> personelistesi) {
		this.personelistesi = personelistesi;
	}

	public int getMeslekId() {
		return meslekId;
	}

	public void setMeslekId(int meslekId) {
		this.meslekId = meslekId;
	}

	public String getMeslekAdi() {
		return meslekAdi;
	}

	public void setMeslekAdi(String meslekAdi) {
		this.meslekAdi = meslekAdi;
	}
	
	

}
