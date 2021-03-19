package com.account.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.account.model.Account;
import com.account.model.User;

public class RelationshipOneToOne {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();

		Account account = createEntityManager.find(Account.class, 1L);
		
		User user  = new User ("Salete",account);
		createEntityManager.getTransaction().begin();
		createEntityManager.persist(user);
		createEntityManager.getTransaction().commit();
		
		
	}
}
