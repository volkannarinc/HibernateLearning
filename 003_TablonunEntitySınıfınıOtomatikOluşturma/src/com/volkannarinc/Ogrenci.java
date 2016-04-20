package com.volkannarinc;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;


/**
 * The persistent class for the ogrenci database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "tumOgrenciKayitlariniGetir",
			query = "SELECT ogr FROM Ogrenci ogr"),

	@NamedQuery(name = "secilenOgrenciKaydiniGetir",
			query = "SELECT ogr FROM Ogrenci ogr WHERE ogr.id = :p_id"),

	@NamedQuery(name = "Ogrenci.AdiSoyadiSorgula",
			query = "SELECT ogr FROM Ogrenci ogr WHERE ogr.adi = :p_adi AND ogr.soyadi = :p_soyadi")
})
public class Ogrenci  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = AUTO)
	private int id;

	@Column(name = "Adi")
	private String adi;

	@Column(name = "Bolum")
	private String bolum;

	@Column(name = "Fakulte")
	private String fakulte;

	@Column(name = "No")
	private int no;

	@Column(name = "Soyadi")
	private String soyadi;

	public Ogrenci() {
	}	
	
	public Ogrenci(String adi, String bolum, String fakulte, int no,
			String soyadi) {
		super();
		this.adi = adi;
		this.bolum = bolum;
		this.fakulte = fakulte;
		this.no = no;
		this.soyadi = soyadi;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return this.adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getBolum() {
		return this.bolum;
	}

	public void setBolum(String bolum) {
		this.bolum = bolum;
	}

	public String getFakulte() {
		return this.fakulte;
	}

	public void setFakulte(String fakulte) {
		this.fakulte = fakulte;
	}

	public int getNo() {
		return this.no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSoyadi() {
		return this.soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

}