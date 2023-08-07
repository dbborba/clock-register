package com.santos.timeclock.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_clockRegister")
public class ClockRegister implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	private Timestamp clockRegister;
	
	public ClockRegister() {
		
	}	
	

	public ClockRegister(Long id, Employee employee, Timestamp clockRegister) {
		super();
		this.id = id;
		this.employee = employee;
		this.clockRegister = clockRegister;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Timestamp getClockRegister() {
		return clockRegister;
	}

	public void setClockRegister(Timestamp clockRegister) {
		this.clockRegister = clockRegister;
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
		ClockRegister other = (ClockRegister) obj;
		return Objects.equals(id, other.id);
	}	
	

}
