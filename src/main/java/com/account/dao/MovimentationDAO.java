package com.account.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.mapping.Array;

import com.account.model.AverageWithDate;
import com.account.model.Movimentation;

public class MovimentationDAO {

	private EntityManager createEntityManager ;
	
	
	public MovimentationDAO(EntityManager createEntityManager) {
		super();
		this.createEntityManager = createEntityManager;
		
	}

	public List<Movimentation> getMovimentationByDate(Integer day,Integer month, Integer year){

		CriteriaBuilder builder = createEntityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<Movimentation> query = builder.createQuery(Movimentation.class);

		Root<Movimentation> root = query.from(Movimentation.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (day != null) {
			Predicate Predicate = builder.equal(builder.function("day", Integer.class, root.get("date")), day);
			predicates.add(Predicate);
		}
		if (month != null) {
			Predicate Predicate = builder.equal(builder.function("month", Integer.class, root.get("date")), month);
			predicates.add(Predicate);
		}
		if (year != null) {
			Predicate Predicate = builder.equal(builder.function("year", Integer.class, root.get("date")), year);
			predicates.add(Predicate);
		}
		
		query.where((Predicate[]) predicates.toArray(new Predicate[0]));
		TypedQuery<Movimentation> typedQuery = createEntityManager.createQuery(query);
		return typedQuery.getResultList();
	}
	
	
	public List<AverageWithDate> getAverage(){

		TypedQuery<AverageWithDate> query = createEntityManager.createNamedQuery("averageWithDate",AverageWithDate.class);
		List<AverageWithDate> averages = query.getResultList();
		
		return averages;
		
	}
	
	public BigDecimal getSum() {
		
		String jpql = "SELECT sum(m.value) from Movimentation m";
		
		TypedQuery<BigDecimal> query = createEntityManager.createQuery(jpql, BigDecimal.class);
		BigDecimal sum = query.getSingleResult();
		
		return sum;
	}
}
