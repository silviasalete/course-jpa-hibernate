package com.account.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JPQLSum {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "SELECT sum(m.value) from Movimentation m";
		
		TypedQuery<BigDecimal> query = createEntityManager.createQuery(jpql, BigDecimal.class);
		BigDecimal sum = query.getSingleResult();
		System.out.println("SUM: "+sum);

	}

}
