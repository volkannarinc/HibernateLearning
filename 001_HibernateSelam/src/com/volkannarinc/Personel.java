package com.volkannarinc;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Personel{
	
	private int personelid;
	private String personelAdi;
	private String personelSoyadi;
	
	@Id
	public int getPersonelid() {
		return personelid;
	}
	public void setPersonelid(int personelid) {
		this.personelid = personelid;
	}
	public String getPersonelAdi() {
		return personelAdi;
	}
	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}
	public String getPersonelSoyadi() {
		return personelSoyadi;
	}
	public void setPersonelSoyadi(String personelSoyadi) {
		this.personelSoyadi = personelSoyadi;
	}
	
	
}
