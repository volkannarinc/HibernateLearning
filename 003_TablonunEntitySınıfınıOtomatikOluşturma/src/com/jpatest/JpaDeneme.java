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
		o.setFakulte("Bilgisyar ve Bili�im M�henslik Fak�ltesi");
		o.setBolum("Bilgisyar M�hendisli�i");
		
		Ogrenci o2 = new Ogrenci("Yunus Emre","Bilgisyar M�hendisli�i","Bilgisyar ve Bili�im M�henslik Fak�ltesi",111210083,"Ko�ak");
		Ogrenci o3 = new Ogrenci("Mehmet Emin","Uluslararas� �li�kiler","IIBF",10141339,"�pek");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_AyarDosyasi");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
				em.persist(o3);
				kayitEkle(em, "�mit", "Bilgisyar M�hendisli�i", "Bilgisyar ve Bili�im M�henslik Fak�ltesi", 23434534, "Aydemir");
				
				em.persist(o);
				kayitEkle(em, "Ahmet", "Bilgisyar M�hendisli�i", "Bilgisyar ve Bili�im M�henslik Fak�ltesi", 567456, "Bozanlar");
				kayitEkle(em, "Kerem", "Bilgisyar M�hendisli�i", "Bilgisyar ve Bili�im M�henslik Fak�ltesi", 34535, "Toker");

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
			
			System.out.println("\n��renci ID: " + ogrenci.getId()
					+"\nOgrenci Adi: " + ogrenci.getAdi()
					+"\nOgrenci Soyadi: " + ogrenci.getSoyadi()
					+"\nOgrenci No: " + ogrenci.getNo()
					+"\nOgrenci Fak�lte: " + ogrenci.getFakulte()
					+"\nOgrenci B�l�m: " + ogrenci.getBolum());
			
		}		
	}

	private static void kayitlariYazSecilen(EntityManager em, int id){
		Query query = em.createQuery("SELECT ogr FROM Ogrenci ogr WHERE ogr.id = " + id);
		
		List<?> list = query.getResultList();
		
		for(Object obj : list){
			Ogrenci ogrenci = (Ogrenci)obj;
			
			System.out.println("\n��renci ID: " + ogrenci.getId()
					+"\nOgrenci Adi: " + ogrenci.getAdi()
					+"\nOgrenci Soyadi: " + ogrenci.getSoyadi()
					+"\nOgrenci No: " + ogrenci.getNo()
					+"\nOgrenci Fak�lte: " + ogrenci.getFakulte()
					+"\nOgrenci B�l�m: " + ogrenci.getBolum());
		}
	}
	
	private static void kayitlariYazSecilenNamedQuery(EntityManager em, int id){
		Query query = em.createNamedQuery("secilenOgrenciKaydiniGetir").setParameter("p_id", id);
		List<?> list = query.getResultList();
		
		for(Object obj : list){
			Ogrenci ogrenci = (Ogrenci)obj;
			
			System.out.println("\n��renci ID: " + ogrenci.getId()
					+"\nOgrenci Adi: " + ogrenci.getAdi()
					+"\nOgrenci Soyadi: " + ogrenci.getSoyadi()
					+"\nOgrenci No: " + ogrenci.getNo()
					+"\nOgrenci Fak�lte: " + ogrenci.getFakulte()
					+"\nOgrenci B�l�m: " + ogrenci.getBolum());
		}
	}
}
