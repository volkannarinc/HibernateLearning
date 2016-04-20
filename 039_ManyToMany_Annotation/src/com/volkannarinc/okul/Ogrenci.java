package com.volkannarinc.okul;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OGRENCI")
public class Ogrenci {

	@Id
	@GeneratedValue
	@Column(name = "OGRENCI_ID")
	private Long ogrenciId;
	
	@Column(name = "OGRENCI_ADI",nullable = false,length = 100)
	private String ogrenciAdi;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "OGRENCI_DERS",
			joinColumns = {@JoinColumn(name = "OGRENCI_ID")},
			inverseJoinColumns = {@JoinColumn(name = "DERS_ID")})
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
