package com.account.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.account.utils.MovimentationType;

@NamedQuery(name="averageWithDate",
query="SELECT new com.account.model.AverageWithDate(avg(m.value), day(m.date), month(m.date)) from Movimentation m GROUP BY day(m.date), month(m.date), year(m.date)")
// aviso errado do eclipse

@Entity
public class Movimentation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private MovimentationType movimentationType;
	private LocalDate date;
	private String description;
	private BigDecimal value;
	
	@ManyToOne
	private Account account;
	
	@ManyToMany
	private List<Category> categories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MovimentationType getMovimentationType() {
		return movimentationType;
	}

	public void setMovimentationType(MovimentationType movimentationType) {
		this.movimentationType = movimentationType;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Movimentation [id=" + id + ", movimentationType=" + movimentationType + ", date=" + date
				+ ", description=" + description + ", value=" + value + ", account=" + account + ", categories="
				+ categories + "]\n";
	}
}
