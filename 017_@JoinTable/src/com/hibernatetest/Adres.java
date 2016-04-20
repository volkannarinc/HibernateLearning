package com.hibernatetest;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//BU SINIFI BAÞKA SINIFLAR TARAFINDAN ÇAÐIRIP
//BÝR ALAN ÝÇÝN GÖMEBÝLÝRÝZ.
@Embeddable
public class Adres {
	@Column(name="IL_ADI")
	public String sehir;
	
	@Column(name="ILCE_ADI")
	public String semt;
	
	@Column(name="CADDE_ADI")
	public String cadde;
	
	@Column(name="KAPI_NO")
	public String kapiNo;

	@Column(name="POSTA_KODU")
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
	
	public String getPostaKodu() {
		return postaKodu;
	}
	public void setPostaKodu(String postaKodu) {
		this.postaKodu = postaKodu;
	}
	
	
}
