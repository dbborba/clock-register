package com.santos.timeclock.DTO;

public class SalaryCalculationRequest {
	
	private String id;
	private Integer year;
	private Integer month;
	
	public SalaryCalculationRequest() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

}
