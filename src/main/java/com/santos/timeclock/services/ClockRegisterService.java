package com.santos.timeclock.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.timeclock.entities.ClockRegister;
import com.santos.timeclock.entities.Employee;
import com.santos.timeclock.repository.ClockRegisterRepository;
import com.santos.timeclock.repository.EmployeeRepository;

@Service
public class ClockRegisterService {
	
	@Autowired
	private ClockRegisterRepository repository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<ClockRegister> findAll() {
		return repository.findAll();
	}
	
	public ClockRegister insert(String stringId) {
		
		Long employeeId = Long.parseLong(stringId);
		
		Employee employee = employeeRepository.findById(employeeId).orElse(null);
		
		if (employee == null) {
			return null;
		}
		
		ClockRegister register = new ClockRegister(null, employee, new Timestamp(System.currentTimeMillis()));
		return repository.save(register);
	}
	
	public List<ClockRegister> list(String id) {
		
		Long employeeId = Long.parseLong(id);
		
		Employee emp = employeeRepository.findById(employeeId).get();
		
		if (emp != null) {
			return emp.clocks;
		} else {
			return null;
		}
	}
	
	public void delete(String stringId) {
		try {
			Long clockId = Long.parseLong(stringId);
			
			try {
				if (repository.existsById(clockId)) {
					repository.deleteById(clockId);;
				} else {
					throw new RuntimeException("Register not found");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch(Exception e) {
			throw new RuntimeException("Invalid ID");
		}
			
	}
	
	public Double calculateSalary(String id, Integer year, Integer month) {
				
		Long employeeId = Long.parseLong(id);
		
		Employee emp = employeeRepository.findById(employeeId).get();
				
		List<ClockRegister> list = emp.getClocks();
		List<ClockRegister> listCalculate = new ArrayList<>();
		
		for (ClockRegister register : list) {
			
			if(register.getClockRegister().toLocalDateTime().getYear() == year && register.getClockRegister().toLocalDateTime().getMonthValue() == month) {				
				listCalculate.add(register);				
			}
		}

		Double calculatedSalary = 0.0;

		int registersCount = listCalculate.size();

		if (registersCount > 1) {

			for (int i = 0; i < registersCount; i += 2) {

				if (i < registersCount - 1) {
					long start = listCalculate.get(i).getClockRegister().getTime();
					long end = listCalculate.get(i + 1).getClockRegister().getTime();
															
					calculatedSalary = calculatedSalary +  (emp.getSalary() * ((end - start)/3600000)) ;					
										
				}
			}
		} else {
			throw new RuntimeException("Register database error");
		}

		return calculatedSalary;
}
}
