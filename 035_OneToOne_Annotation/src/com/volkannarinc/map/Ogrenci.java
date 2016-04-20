package com.volkannarinc.map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ogrenci",catalog="denemevt")
public class Ogrenci {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "OGRENCI_ID",unique=true,nullable=false)
	private int ogrenciId;
	
	@Column(name = "OGRENCI_SOYADI",nullable=false,length=50)
	private String ogrenciSoyadi;
	
	@Column(name = "OGRENCI_ADI",nullable=false,length=50)
	private String ogrenciAdi;
	
	@OneToOne(mappedBy = "ogrenci",cascade = CascadeType.ALL)
	private OgrenciBilgisi ogrenciBilgiai;
	
	public Ogrenci() {
		// TODO Auto-generated constructor stub
	}
	
	public Ogrenci(String ogrenciAdi,String ogrenciSoyadi) {
		this.ogrenciAdi = ogrenciAdi;
		this.ogrenciSoyadi = ogrenciSoyadi;
	}

	public int getOgrenciId() {
		return ogrenciId;
	}

	public void setOgrenciId(int ogrenciId) {
		this.ogrenciId = ogrenciId;
	}

	public String getOgrenciSoyadi() {
		return ogrenciSoyadi;
	}

	public void setOgrenciSoyadi(String ogrenciSoyadi) {
		this.ogrenciSoyadi = ogrenciSoyadi;
	}

	public String getOgrenciAdi() {
		return ogrenciAdi;
	}

	public void setOgrenciAdi(String ogrenciAdi) {
		this.ogrenciAdi = ogrenciAdi;
	}

	public OgrenciBilgisi getOgrenciBilgisi() {
		return ogrenciBilgiai;
	}

	public void setOgrenciBilgisi(OgrenciBilgisi ogrenciBilgiai) {
		this.ogrenciBilgiai = ogrenciBilgiai;
	}

}
