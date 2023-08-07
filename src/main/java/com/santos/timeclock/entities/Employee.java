package com.santos.timeclock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_employee")
public class Employee implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	private String name;
	private String department;
	private String function;
	private Integer documentId;
	private BigDecimal salary;
	
	public Employee() {
		
	}
	
	

	public Employee(Long id, String name, String department, String function, Integer documentId, BigDecimal salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.function = function;
		this.documentId = documentId;
		this.salary = salary;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}



	public String getFunction() {
		return function;
	}



	public void setFunction(String function) {
		this.function = function;
	}



	public Integer getDocumentId() {
		return documentId;
	}



	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}
			
}
