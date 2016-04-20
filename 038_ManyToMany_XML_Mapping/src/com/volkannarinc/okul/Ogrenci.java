package com.volkannarinc.okul;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ogrenci {

	private Long ogrenciId;
	private String ogrenciAdi;
	private Set<Ders> dersler = new HashSet<Ders>(0);
	

	public Ogrenci() {
		// TODO Auto-generated constructor stub
	}
	
	public Ogrenci(String ogrenciAdi) {
		this.ogrenciAdi = ogrenciAdi;
	}
	
	public Ogrenci(String ogrenciAdi,Set<Ders> dersler) {
		this.ogrenciAdi = ogrenciAdi;
		this.dersler = dersler;
	}

	public Long getOgrenciId() {
		return ogrenciId;
	}

	public void setOgrenciId(Long ogrenciId) {
		this.ogrenciId = ogrenciId;
	}

	public String getOgrenciAdi() {
		return ogrenciAdi;
	}

	public void setOgrenciAdi(String ogrenciAdi) {
		this.ogrenciAdi = ogrenciAdi;
	}

	public Set<Ders> getDersler() {
		return dersler;
	}

	public void setDersler(Set<Ders> dersler) {
		this.dersler = dersler;
	}


	
	
}
