package com.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.volkannarinc.Meslek;
import com.volkannarinc.Sektor;
import com.volkannarinc.Tecrube;

public class HibernateDeneme {

	public static void main(String[] args) {

		Meslek meslek = new Meslek();
		meslek.setMeslekAdi("Serbest");
	//------------------------------------------------
		Sektor sektor = new Sektor();
		sektor.setMeslekAdi("Bilgisayar M�hendisli�i");
		sektor.setCalismaAlani("Java");
	//------------------------------------------------
		Tecrube tecrube = new Tecrube();
		tecrube.setMeslekAdi("Proje Y�neticisi");
		tecrube.setDeneyimYili(5);
	//------------------------------------------------
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(meslek);
		session.save(tecrube);
		session.save(sektor);
		session.getTransaction().commit();
		session.close();
	}

}	
