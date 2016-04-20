package com.volkannarinc;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.hibernatetest.Adres;

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
	
	@Temporal(TemporalType.DATE)
	private Date personelKayitTarihi;
	
	
	/*
	 * @ElementCollection: ÇOCUK DETAY TABLOLARINI OLUÞTURMAYA YARAR.PERSONEL_ADRESLÝSTESÝ ADINDA TABLO OLUÞUR
	SINIFADI_DÝPNOTUN KULLANILDIÐI NESNE.KOLEKSÝYON SINIFLARIYLA BERABER KULLANILIR.(HashSet,Collection)
	
		@JoinTable : ÇOCUK DETAY ALT TABLONUN ADINI DEÐÝÞTÝRÝR.
	ARALARINDA ÝLÝÞKÝ BULUNAN ÝKÝ TABLONUN BÝRÝNCÝL ANAHTARLARINI
	YENÝ BÝR TABLODA @JoinTable ÝLE BÝR ARAYA GETÝRÝR.MEYDANA
	GELEN BU YENÝ TABLOYA KALITIM TABLOSU DENÝR.Geri PLANDAKÝ SINIFLA ÝLETÝÞÝMÝ SAÐLAR.

		@JoinColumn : ÇOCUK DETAY ALT TABLODAKÝ ID KOLONUN ADINI DEÐÝÞTÝRÝR
	@JoinColumn ÝLE ARALARINDA ÝLÝÞKÝ BULUNAN ÝKÝ ABLODAN 
	HAKÝM TABLONUN SONUNA BÝR ALAN EKLENÝR.BU EKLENEN KOLONDA
	DÝÐER TABLONUN BÝRÝNCÝL ANAHTARLARI YER ALIR. BU KOLONA, 
	KALITIM SÜTUNU DENÝR.*/
	@ElementCollection  
	@JoinTable(name="personeladrestablosu",
	joinColumns = @JoinColumn(name="personel_id"))	
	@GenericGenerator(name="hilo-gen",strategy="hilo")
	@CollectionId(
			columns={@Column(name="ADRES_ID")},
			generator="hilo-gen",
			type=@Type(type="long")
			)
	private Collection<Adres> adresListesi = new ArrayList<Adres>();
	
	public Collection<Adres> getAdresListesi() {
		return adresListesi;
	}


	public void setAdresListesi(Collection<Adres> adresListesi) {
		this.adresListesi = adresListesi;
	}


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


	public Date getPersonelKayitTarihi() {
		return personelKayitTarihi;
	}


	public void setPersonelKayitTarihi(Date personelKayitTarihi) {
		this.personelKayitTarihi = personelKayitTarihi;
	}
	
   
}
