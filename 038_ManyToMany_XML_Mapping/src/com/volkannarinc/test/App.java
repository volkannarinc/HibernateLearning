package com.volkannarinc.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.volkannarinc.okul.Ders;
import com.volkannarinc.okul.Ogrenci;
import com.volkannarinc.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
		transaction = session.beginTransaction();
		
		Set<Ders> dersler = new HashSet<Ders>();
		dersler.add(new Ders("JSF - JavaServer Faces"));
		dersler.add(new Ders("JPA - Java Persistence API"));
		dersler.add(new Ders("Hibernate"));

		Ogrenci ogrenci1 = new Ogrenci("Volkan Narinç",dersler);
		Ogrenci ogrenci2 = new Ogrenci("Mehmet Keskin",dersler);
		session.save(ogrenci1);
		session.save(ogrenci2);

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
