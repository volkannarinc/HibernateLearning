package com.volkannarinc.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.volkannarinc.map.Calisan;
import com.volkannarinc.map.Departman;
import com.volkannarinc.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
		transaction = session.beginTransaction();
		
		Departman departman = new Departman();
		departman.setDepartmanAdi("Donanim");
		session.save(departman);

		Calisan calisan1 = new Calisan("Volkan","Narinç","5542867634");
		Calisan calisan2 = new Calisan("Binnur","Hasdemir","5064595813");
		Calisan calisan3 = new Calisan("Burak","Narinç",new Date(),"577689445");
		Calisan calisan4 = null;
		
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date date = format.parse("1990-01-02");
			calisan4 = new Calisan("Mehmet", "Keskin", date, "57873453637");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		calisan1.setDepartman(departman);
		calisan2.setDepartman(departman);
		calisan3.setDepartman(departman);
		
		session.save(calisan1);
		session.save(calisan2);
		session.save(calisan3);
		
		Departman departman2 = new Departman();
		departman2.setDepartmanAdi("Yazilim");
		session.save(departman2);
		
		calisan4.setDepartman(departman2);

		session.save(calisan4);
		
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
