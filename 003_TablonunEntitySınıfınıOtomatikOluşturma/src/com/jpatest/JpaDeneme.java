package com.jpatest;


import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.volkannarinc.Ogrenci;

public class JpaDeneme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ogrenci o = new Ogrenci();
		o.setAdi("Mehmet");
		o.setSoyadi("Keskin");
		o.setNo(111210081);
		o.setFakulte("Bilgisyar ve Biliþim Mühenslik Fakültesi");
		o.setBolum("Bilgisyar Mühendisliði");
		
		Ogrenci o2 = new Ogrenci("Yunus Emre","Bilgisyar Mühendisliði","Bilgisyar ve Biliþim Mühenslik Fakültesi",111210083,"Koçak");
		Ogrenci o3 = new Ogrenci("Mehmet Emin","Uluslararasý Ýliþkiler","IIBF",10141339,"Ýpek");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_AyarDosyasi");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
				em.persist(o3);
				kayitEkle(em, "Ümit", "Bilgisyar Mühendisliði", "Bilgisyar ve Biliþim Mühenslik Fakültesi", 23434534, "Aydemir");
				
				em.persist(o);
				kayitEkle(em, "Ahmet", "Bilgisyar Mühendisliði", "Bilgisyar ve Biliþim Mühenslik Fakültesi", 567456, "Bozanlar");
				kayitEkle(em, "Kerem", "Bilgisyar Mühendisliði", "Bilgisyar ve Biliþim Mühenslik Fakültesi", 34535, "Toker");

				em.persist(o2);
			et.commit();
		} catch (RuntimeException re) {
			
			et.rollback();
			System.out.println("HATA!! -> " + re);
		}finally {
			if(em != null){
				kayitlariYazHepsi(em);
				kayitlariYazSecilen(em, 2);
				
				em.close();
				emf.close();
			}
		}
		
	}
	
	private static void kayitEkle(EntityManager em,String adi, String bolum,
			String fakulte, int no,String soyadi){
		Ogrenci ogrenci = new Ogrenci(adi,bolum,fakulte,no,soyadi);
		em.persist(ogrenci);
	}
	
	private static void kayitlariYazHepsi(EntityManager em){
		Query query = em.createNamedQuery("tumOgrenciKayitlariniGetir");
		List<?> list = query.getResultList();
		
		for (Object obj : list) {
			Ogrenci ogrenci = (Ogrenci) obj;
			
			System.out.println("\nÖðrenci ID: " + ogrenci.getId()
					+"\nOgrenci Adi: " + ogrenci.getAdi()
					+"\nOgrenci Soyadi: " + ogrenci.getSoyadi()
					+"\nOgrenci No: " + ogrenci.getNo()
					+"\nOgrenci Fakülte: " + ogrenci.getFakulte()
					+"\nOgrenci Bölüm: " + ogrenci.getBolum());
			
		}		
	}

	private static void kayitlariYazSecilen(EntityManager em, int id){
		Query query = em.createQuery("SELECT ogr FROM Ogrenci ogr WHERE ogr.id = " + id);
		
		List<?> list = query.getResultList();
		
		for(Object obj : list){
			Ogrenci ogrenci = (Ogrenci)obj;
			
			System.out.println("\nÖðrenci ID: " + ogrenci.getId()
					+"\nOgrenci Adi: " + ogrenci.getAdi()
					+"\nOgrenci Soyadi: " + ogrenci.getSoyadi()
					+"\nOgrenci No: " + ogrenci.getNo()
					+"\nOgrenci Fakülte: " + ogrenci.getFakulte()
					+"\nOgrenci Bölüm: " + ogrenci.getBolum());
		}
	}
	
	private static void kayitlariYazSecilenNamedQuery(EntityManager em, int id){
		Query query = em.createNamedQuery("secilenOgrenciKaydiniGetir").setParameter("p_id", id);
		List<?> list = query.getResultList();
		
		for(Object obj : list){
			Ogrenci ogrenci = (Ogrenci)obj;
			
			System.out.println("\nÖðrenci ID: " + ogrenci.getId()
					+"\nOgrenci Adi: " + ogrenci.getAdi()
					+"\nOgrenci Soyadi: " + ogrenci.getSoyadi()
					+"\nOgrenci No: " + ogrenci.getNo()
					+"\nOgrenci Fakülte: " + ogrenci.getFakulte()
					+"\nOgrenci Bölüm: " + ogrenci.getBolum());
		}
	}
}
