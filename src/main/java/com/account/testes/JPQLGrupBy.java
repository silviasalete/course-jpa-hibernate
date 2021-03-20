package com.account.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.account.model.AverageWithDate;

public class JPQLGrupBy {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "SELECT new com.account.model.AverageWithDate(avg(m.value),day(m.date), month(m.date)) from Movimentation m GROUP BY day(m.date), month(m.date), year(m.date)";
		
		TypedQuery<AverageWithDate> query = createEntityManager.createQuery(jpql,AverageWithDate.class);
		List<AverageWithDate> averages = query.getResultList();
		
		for (AverageWithDate object : averages) {
			System.out.println("Average of movimentations of day "+object.getDay()+"/"+object.getMonth()+" is: "+object.getValue());
		}
		

	}

}
