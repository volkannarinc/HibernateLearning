package com.jpatest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaDeneme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Personel personel = new Personel();
		//personel.setPersonelid(1);
		personel.setPersonelAdi("Volkan");
		personel.setPersonelSoyadi("Narinç");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("002_SelamJPA");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
			em.persist(personel);
		et.commit();
		
		System.out.println("\nID: " + personel.getPersonelid() 
							+ "\nADI: " + personel.getPersonelAdi()
							+ "\nSOYADI" + personel.getPersonelSoyadi());
		em.close();
		emf.close();
	}

}
