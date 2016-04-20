package com.volkannarinc;


import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.volkannarinc.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main obj = new Main();
		Long personelId1 = obj.personelKaydet("Volkan Narinç");
		Long personelId2 = obj.personelKaydet("Binnur Hasdemir");
		Long personelId3 = obj.personelKaydet("Mehmet Keskin");
		Long personelId4 = obj.personelKaydet("Yunus Emre Koçak");
		Long personelId5 = obj.personelKaydet("Mehmet Emin Ýpek");
		Long personelId6 = obj.personelKaydet("Dilara Aslan");
		obj.personelListele();
		
		obj.personelGuncelle(personelId3, "Kerem Toker");
		obj.personelSil(personelId2);
		obj.personelSil(personelId6);
		obj.personelGuncelle(personelId5, "Ömer Artuç");
		obj.personelSil(personelId4);
		obj.personelListele();
		
		obj.personelGuncelle(personelId3, "Berna Demirkýran");
		obj.personelListele();


	}
	
	public Long personelKaydet(String personelAdi){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long personelId = null;
		try {
			transaction = session.beginTransaction();
			Personel personel = new Personel();
			personel.setPersonelAdi(personelAdi);
			personelId = (Long) session.save(personel);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return personelId;
	}

	public void personelListele(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
		transaction = session.beginTransaction();
		List<?> personels = session.createQuery("FROM Personel").list();
		for (Iterator<?> iterator = personels.iterator(); iterator.hasNext();) {
			Personel personel = (Personel) iterator.next();
			System.out.println(personel.getPersonelAdi());
		}
		transaction.commit();
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public void personelGuncelle(long personelId,String personelAdi) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Personel personel = (Personel) session.get(Personel.class, personelId);
			personel.setPersonelAdi(personelAdi);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public void personelSil(long personelId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Personel personel = (Personel) session.get(Personel.class, personelId);
			session.delete(personel);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
