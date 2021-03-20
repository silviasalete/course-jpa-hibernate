package com.account.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.account.model.Account;
import com.account.model.Movimentation;

public class RelationshipTwoDimensional {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		
		Movimentation movimentation = createEntityManager.find(Movimentation.class, 1L);
		Account account = movimentation.getAccount();
		int sizeMovimentations = account.getMovimentations().size();
		System.out.println(sizeMovimentations);

	}

}
