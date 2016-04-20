package com.volkannarinc.map;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="ogrenci_bilgisi",catalog="denemevt")
public class OgrenciBilgisi {

	@GenericGenerator(name = "generator",
					strategy ="foreign",
					parameters = @Parameter(name = "property",value = "ogrenci"))
	@Id
	@GeneratedValue(generator ="generator")
	@Column(name = "OGRENCI_ID", unique=true,nullable = false)
	private Integer ogrenciId;
	
	@Column(name = "ADRES",nullable = false,length =255)
	private String adres;
	
	@Column(name = "KAYIT_NO",length =20)
	private String kayitNo;
	
	@Column(name = "TELEFON_NO",length =50)
	private String telefonNo;
	
	@Column(name = "EMAIL",length =255)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DOGUM_TARIHI",length =10,nullable=false)
	private Date dogumTarihi;
	
	@Column(name = "KAYIT_TARIHI",length =10,nullable=false)
	private Date kayitTarihi;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	/*EK ALAN OLUÞTURMADAM YABANCI ANAHTARIN EÞLEÞTÝRMESÝNÝ YAPAR.
	 * EÐER BU KULLANILIRSA TABLOLAR ARASINDA FÝZÝKSEL BAÐLANTI OLMAZ!*/
	private Ogrenci ogrenci;
	
	public OgrenciBilgisi() {
		// TODO Auto-generated constructor stub
	}

	public Integer getOgrenciId() {
		return ogrenciId;
	}

	public void setOgrenciId(Integer ogrenciId) {
		this.ogrenciId = ogrenciId;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getKayitNo() {
		return kayitNo;
	}

	public void setKayitNo(String kayitNo) {
		this.kayitNo = kayitNo;
	}

	public String getTelefonNo() {
		return telefonNo;
	}

	public void setTelefonNo(String telefonNo) {
		this.telefonNo = telefonNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDogumTarihi() {
		return dogumTarihi;
	}

	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}

	public Date getKayitTarihi() {
		return kayitTarihi;
	}

	public void setKayitTarihi(Date kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
	}

	public Ogrenci getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}

}
