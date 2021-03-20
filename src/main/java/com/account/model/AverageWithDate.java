package com.account.model;

public class AverageWithDate {
	
	private Integer day;
	private Integer month;
	private Double value;
	
	public AverageWithDate(Double value, Integer day, Integer month) {
		this.day = day;
		this.month = month;
		this.value = value;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	

}
