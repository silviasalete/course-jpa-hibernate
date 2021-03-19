package com.account.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.account.model.User;

public class DeleteUser {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();

		User user = createEntityManager.find(User.class, 1L);
		user.setName("Eduardo Júnior");
		
		createEntityManager.getTransaction().begin();
		createEntityManager.remove(user);
		createEntityManager.getTransaction().commit();


	}

}
