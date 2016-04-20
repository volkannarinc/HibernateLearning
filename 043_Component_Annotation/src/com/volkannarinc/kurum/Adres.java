package com.volkannarinc.kurum;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//BU SINIFI BAÞKA SINIFLAR TARAFINDAN ÇAÐIRIP
//BÝR ALAN ÝÇÝN GÖMEBÝLÝRÝZ.
@Embeddable
public class Adres {
	
	private long adresId;
	
	@Column(name="ADRES_SEHIR", nullable =false,length=50)
	private String sehir;

	@Column(name="ADRES_SEMT", nullable =false,length=50)
	private String semt;
	
	@Column(name="ADRES_CADDE", nullable =false,length=250)
	private String cadde;
	
	@Column(name="ADRES_POSTAKODU", nullable =false,length=10)
	private String postaKodu;
	
	public Adres(){
		
	}
	
	
	
	public Adres(String cadde,String sehir,String semt,String postaKodu) {
		this.cadde = cadde;
		this.sehir = sehir;
		this.semt = semt;
		this.postaKodu = postaKodu;
	}



	public long getAdresId() {
		return adresId;
	}



	public void setAdresId(long adresId) {
		this.adresId = adresId;
	}



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



	public String getPostaKodu() {
		return postaKodu;
	}



	public void setPostaKodu(String postaKodu) {
		this.postaKodu = postaKodu;
	}
	
	
}
