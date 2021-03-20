package com.account.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.account.model.Account;
import com.account.model.Movimentation;

public class JPQLOrderBy {
	public static void main(String[] args) {		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		
		Account account = createEntityManager.find(Account.class, 5L);

		String jpql = "SELECT m FROM Movimentation m WHERE m.account = :pAccount order by m.value asc";
		
		TypedQuery<Movimentation> createQuery = createEntityManager.createQuery(jpql,Movimentation.class);
		createQuery.setParameter("pAccount", account);
		
		List<Movimentation> resultList = createQuery.getResultList();

		for (Movimentation movimentation : resultList) {
			System.out.println("Description: "+movimentation.getDescription());
			System.out.println("Value: "+movimentation.getValue());
			System.out.println("Type: "+movimentation.getMovimentationType());
		}
		
	}
}
