package com.account.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JPQLAverage {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "SELECT avg(m.value) from Movimentation m";
		
		TypedQuery<Double> query = createEntityManager.createQuery(jpql, Double.class);
		Double avg = query.getSingleResult();
		System.out.println("AVG: "+avg);

	}

}
