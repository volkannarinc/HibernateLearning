package com.volkannarinc.kurum;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TELEFON",catalog="denemevt")
public class Telefon implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "TELEFON_ID")
	private long telefonId;
	
	@Column(name = "TELEFON_TIPI",nullable=false,length=10)
	private String telefonTipi;
	
	@Column(name = "TELEFON_NO",nullable=false,length=15)
	private String telefonNo;

	
	public Telefon() {
		// TODO Auto-generated constructor stub
	}
	
	public Telefon(String telefonTipi,String telefonNo) {
		this.telefonTipi = telefonTipi;
		this.telefonNo = telefonNo;
	}

	public long getTelefonId() {
		return telefonId;
	}

	public void setTelefonId(long telefonId) {
		this.telefonId = telefonId;
	}

	public String getTelefonTipi() {
		return telefonTipi;
	}

	public void setTelefonTipi(String telefonTipi) {
		this.telefonTipi = telefonTipi;
	}

	public String getTelefonNo() {
		return telefonNo;
	}

	public void setTelefonNo(String telefonNo) {
		this.telefonNo = telefonNo;
	}



	

}
