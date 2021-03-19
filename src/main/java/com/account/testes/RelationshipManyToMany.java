package com.account.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.account.model.Account;
import com.account.model.Category;
import com.account.model.Movimentation;
import com.account.utils.MovimentationType;

public class RelationshipManyToMany {
	
	public static void main(String[] args) {
		
		Account account = new Account();
		account.setNumber(123);
		account.setAgency(321);
		account.setBalance(100.00);
		account.setHolder("Silvia");
		
		Category category1 = new Category("Trips");
		Category category2 = new Category("Business");
		
		Movimentation movimentation1 = new Movimentation();
		movimentation1.setAccount(account);
		movimentation1.setDate(LocalDate.now());
		movimentation1.setDescription("Trip from BR to USA");
		movimentation1.setValue(new BigDecimal(255.00));
		movimentation1.setMovimentationType(MovimentationType.EXIT);
		movimentation1.setCategories(Arrays.asList(category1,category2));
		
		Movimentation movimentation2 = new Movimentation();
		movimentation2.setAccount(account);
		movimentation2.setDate(LocalDate.now());
		movimentation2.setDescription("Trip from USA to BR");
		movimentation2.setValue(new BigDecimal(255.00));
		movimentation2.setMovimentationType(MovimentationType.EXIT);
		movimentation2.setCategories(Arrays.asList(category1,category2));
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		
		createEntityManager.getTransaction().begin();
		createEntityManager.persist(account);
		createEntityManager.persist(category1);
		createEntityManager.persist(category2);
		createEntityManager.persist(movimentation1);
		createEntityManager.persist(movimentation2);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
	}
}
