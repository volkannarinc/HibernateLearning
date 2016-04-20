package com.volkannarinc.kurum;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="PERSONEL",catalog="denemevt")
public class Personel {

	@GenericGenerator(name = "generator",
					strategy ="foreign",
					parameters = @Parameter(name = "property",value = "ogrenci"))
	@Id
	@GeneratedValue
	@Column(name = "PERSONEL_ID")
	private long personelId;
	
	@Column(name = "PERSONEL_ADI",nullable = false,length = 100)
	private String personelAdi;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PERSONEL_TELEFON",
			joinColumns = { @JoinColumn(name = "PERSONEL_ID")},
			inverseJoinColumns = {@JoinColumn(name = "TELEFON_ID")})	
	private Set<Telefon> personelTelefonNolari = new HashSet<Telefon>(0);
	
	public Personel(){
		
	}

	public Personel(String personelAdi){
		this.personelAdi = personelAdi;
	}
	
	public Personel(String personelAdi,Set<Telefon> personelTelefonNolari){
		this.personelAdi = personelAdi;
		this.personelTelefonNolari = personelTelefonNolari;
	}

	public long getPersonelId() {
		return personelId;
	}

	public void setPersonelId(long personelId) {
		this.personelId = personelId;
	}

	public String getPersonelAdi() {
		return personelAdi;
	}

	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}

	public Set<Telefon> getPersonelTelefonNolari() {
		return personelTelefonNolari;
	}

	public void setPersonelTelefonNolari(Set<Telefon> personelTelefonNolari) {
		this.personelTelefonNolari = personelTelefonNolari;
	}

}
