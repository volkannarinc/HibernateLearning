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
@Table(name="personeltablosu") //VER�TABANI TABLO ADI
public class Personel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	//OTOTMAT�K ID DE�ER�
	private int personelId;
	private String personelAdi;	
	private String personelSoyadi;	
	
	@Temporal(TemporalType.DATE)
	private Date personelKayitTarihi;
	
	
	/*
	 * @ElementCollection: �OCUK DETAY TABLOLARINI OLU�TURMAYA YARAR.PERSONEL_ADRESL�STES� ADINDA TABLO OLU�UR
	SINIFADI_D�PNOTUN KULLANILDI�I NESNE.KOLEKS�YON SINIFLARIYLA BERABER KULLANILIR.(HashSet,Collection)
	
		@JoinTable : �OCUK DETAY ALT TABLONUN ADINI DE���T�R�R.
	ARALARINDA �L��K� BULUNAN �K� TABLONUN B�R�NC�L ANAHTARLARINI
	YEN� B�R TABLODA @JoinTable �LE B�R ARAYA GET�R�R.MEYDANA
	GELEN BU YEN� TABLOYA KALITIM TABLOSU DEN�R.Geri PLANDAK� SINIFLA �LET���M� SA�LAR.

		@JoinColumn : �OCUK DETAY ALT TABLODAK� ID KOLONUN ADINI DE���T�R�R
	@JoinColumn �LE ARALARINDA �L��K� BULUNAN �K� ABLODAN 
	HAK�M TABLONUN SONUNA B�R ALAN EKLEN�R.BU EKLENEN KOLONDA
	D��ER TABLONUN B�R�NC�L ANAHTARLARI YER ALIR. BU KOLONA, 
	KALITIM S�TUNU DEN�R.*/
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
