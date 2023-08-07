package com.santos.timeclock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.timeclock.entities.Employee;
import com.santos.timeclock.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> findAll() {
		return repository.findAll();
	}
	
	public Employee insert(Employee obj) {
		return repository.save(obj);
	}

}
