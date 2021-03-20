package com.account.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import com.account.model.Movimentation;

public class CriteriaQuery {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		
		CriteriaBuilder builder = createEntityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
		
		Root<Movimentation> root = query.from(Movimentation.class);
		
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("value"));
		
		query.select(sum);
		
		TypedQuery<BigDecimal> typedQuery = createEntityManager.createQuery(query);
		
		System.out.println("SUM: "+typedQuery.getSingleResult());

	}
}
