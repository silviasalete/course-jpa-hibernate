package com.account.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.account.model.Category;
import com.account.model.Movimentation;

public class JPQLJoin {
	public static void main(String[] args) {		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		
		Category category = createEntityManager.find(Category.class, 2L);

		String jpql = "SELECT m FROM Movimentation m JOIN  m.categories c WHERE c = :pCategory";
		
		TypedQuery<Movimentation> createQuery = createEntityManager.createQuery(jpql,Movimentation.class);
		createQuery.setParameter("pCategory", category);
		
		List<Movimentation> resultList = createQuery.getResultList();

		for (Movimentation movimentation : resultList) {
			System.out.println("Catgories: "+movimentation.getCategories());
			System.out.println("Description: "+movimentation.getDescription());
			System.out.println("Value: "+movimentation.getValue());
			System.out.println("Type: "+movimentation.getMovimentationType());
		}
		
	}
}
