package com.account.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateTableTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		createEntityManager.close();

	}

}
