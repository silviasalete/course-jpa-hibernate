package com.account.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.account.model.Account;

public class JPQLLeftJoin {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "SELECT a from Account a left join fetch a.movimentations";
		TypedQuery<Account> query = createEntityManager.createQuery(jpql, Account.class);
		
		List<Account> resultList = query.getResultList();
		for (Account account : resultList) {
			System.out.println("Holder: "+account.getHolder());
			System.out.println("Agency: "+account.getAgency());
			System.out.println("Number: "+account.getNumber());
			System.out.println("Movimentations: "+account.getMovimentations());
		}
	}
}
