package com.volkannarinc.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.volkannarinc.map.Ogrenci;
import com.volkannarinc.map.OgrenciBilgisi;
import com.volkannarinc.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
		transaction = session.beginTransaction();
		
		Ogrenci ogrenci = new Ogrenci("Mehmet","Keskin");
		
		OgrenciBilgisi ogrenciBilgisi = new OgrenciBilgisi();
		ogrenciBilgisi.setAdres("Sakarya");
		ogrenciBilgisi.setKayitNo("234234");
		ogrenciBilgisi.setTelefonNo("2247889789");
		ogrenciBilgisi.setEmail("cs.mehmet.keskin@gmail.com");
		ogrenciBilgisi.setKayitTarihi(new Date());

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date date = format.parse("1990-01-02");
			ogrenciBilgisi.setDogumTarihi(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ogrenciBilgisi.setOgrenci(ogrenci);
		ogrenci.setOgrenciBilgisi(ogrenciBilgisi);
		
		session.save(ogrenci);
		
		transaction.commit();
		
		System.out.println("Baþarýlý olarak kaydedildi.");
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

}
