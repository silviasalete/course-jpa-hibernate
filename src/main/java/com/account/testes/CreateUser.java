package com.account.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.account.model.Account;
import com.account.model.User;

public class CreateUser {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Account account = new Account();
		account.setAgency(5555);
		account.setBalance(506.00);
		account.setHolder("Eduardo");
		account.setNumber(64);
		
		User user = new User("Eduardo",account);
		
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
	}
}
