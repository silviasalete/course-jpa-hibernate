package com.account.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.account.model.User;

public class ReadUser {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		User user = entityManager.find(User.class, 2L);
		user.setName("Eduardo Júnior"); 
		
		System.out.println("User name: "+user.getName());
		
	}
}
