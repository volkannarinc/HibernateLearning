package com.hibernatetest;

import javax.persistence.Embeddable;

//BU SINIFI BA�KA SINIFLAR TARAFINDAN �A�IRIP
//B�R ALAN ���N G�MEB�L�R�Z.
@Embeddable
public class Adres {
	public String sehir;
	public String semt;
	public String mahalle;
	public String cadde;
	public String kapiNo;
	public String kat;
	public String daireNo;
	public String postaKodu;
	
	public String getSehir() {
		return sehir;
	}
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	public String getSemt() {
		return semt;
	}
	public void setSemt(String semt) {
		this.semt = semt;
	}
	public String getMahalle() {
		return mahalle;
	}
	public void setMahalle(String mahalle) {
		this.mahalle = mahalle;
	}
	public String getCadde() {
		return cadde;
	}
	public void setCadde(String cadde) {
		this.cadde = cadde;
	}
	public String getKapiNo() {
		return kapiNo;
	}
	public void setKapiNo(String kapiNo) {
		this.kapiNo = kapiNo;
	}
	public String getKat() {
		return kat;
	}
	public void setKat(String kat) {
		this.kat = kat;
	}
	public String getDaireNo() {
		return daireNo;
	}
	public void setDaireNo(String daireNo) {
		this.daireNo = daireNo;
	}
	public String getPostaKodu() {
		return postaKodu;
	}
	public void setPostaKodu(String postaKodu) {
		this.postaKodu = postaKodu;
	}
	
	
}
