package com.jpatest;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;


/**
 * The persistent class for the personel database table.
 * 
 */
@Entity
public class Personel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PERSONELID")
	@GeneratedValue(strategy = AUTO)
	private int personelid;

	private String personelAdi;

	private String personelSoyadi;

	public Personel() {
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