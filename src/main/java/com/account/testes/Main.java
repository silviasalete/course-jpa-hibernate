package com.account.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.account.dao.MovimentationDAO;
import com.account.model.AverageWithDate;
import com.account.model.Movimentation;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_accounts");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		
		MovimentationDAO movimentationDAO = new MovimentationDAO(createEntityManager);
		List<AverageWithDate> averageMovimentation = movimentationDAO.getAverage();

		for (AverageWithDate object : averageMovimentation) {
			System.out.println("Average of movimentations of day "+object.getDay()+"/"+object.getMonth()+" is: "+object.getValue());
		}
		
		List<Movimentation> movimentationByDate = movimentationDAO.getMovimentationByDate(18, 3, null);
		for (Movimentation movimentation : movimentationByDate) {
			movimentation.toString();
			
		}
		
		BigDecimal sum = movimentationDAO.getSum();
		System.out.println("SUM: "+sum);

	}

}
