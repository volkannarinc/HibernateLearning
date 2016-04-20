package com.jpatest;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;

/**
 * Entity implementation class for Entity: Personel
 *
 */
@Entity

public class Personel implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = AUTO)
	private int personelid;
	private String personelAdi;
	private String personelSoyadi;
	private static final long serialVersionUID = 1L;

	public Personel() {
		super();
	}   
	public int getPersonelid() {
		return this.personelid;
	}

	public void setPersonelid(int personelid) {
		this.personelid = personelid;
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
   
}
