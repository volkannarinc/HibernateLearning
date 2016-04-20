package com.volkannarinc.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.volkannarinc.kurum.Adres;
import com.volkannarinc.kurum.Personel;
import com.volkannarinc.util.HibernateUtil;

public class App {

	public static void main(String[] args) {  
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
		transaction = session.beginTransaction();
		
		Adres adres = new Adres("Üniversite Caddesi","Sakarya","Esentepe","54783");
		
		Personel personel = new Personel("Volkan nARÝNÇ",adres);
		session.save(personel);

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
