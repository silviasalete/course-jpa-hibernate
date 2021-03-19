package com.account.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.account.model.User;

public class CreateUser {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		User user = new User();
		user.setName("Eduardo");
		
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
	}
}
