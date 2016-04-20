package com.volkannarinc.test;



import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.volkannarinc.kurum.Personel;
import com.volkannarinc.kurum.Telefon;
import com.volkannarinc.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
		transaction = session.beginTransaction();
	
		Set<Telefon> telefonNolari = new HashSet<Telefon>();
		telefonNolari.add(new Telefon("Ev","02645642343"));
		telefonNolari.add(new Telefon("Cep","05542867634"));
		
		Personel personel = new Personel("Volkan Narinç",telefonNolari);
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
