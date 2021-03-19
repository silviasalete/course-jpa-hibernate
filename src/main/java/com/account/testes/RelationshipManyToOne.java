package com.account.testes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.account.model.Account;
import com.account.model.Movimentation;
import com.account.utils.MovimentationType;

public class RelationshipManyToOne {

	public static void main(String[] args) {
		
		Account account = new Account();
		account.setNumber(123);
		account.setAgency(321);
		account.setBalance(100.00);
		account.setHolder("Kiara");
		
		Movimentation movimentation = new Movimentation();
		movimentation.setAccount(account);
		movimentation.setDate(LocalDate.now());
		movimentation.setDescription("shopping");
		movimentation.setValue(new BigDecimal(255.00));
		movimentation.setMovimentationType(MovimentationType.EXIT);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		
		createEntityManager.getTransaction().begin();
		createEntityManager.persist(account);
		createEntityManager.persist(movimentation);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
	}

}
