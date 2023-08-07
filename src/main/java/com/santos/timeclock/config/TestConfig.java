package com.santos.timeclock.config;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.santos.timeclock.entities.ClockRegister;
import com.santos.timeclock.entities.Employee;
import com.santos.timeclock.repository.ClockRegisterRepository;
import com.santos.timeclock.repository.EmployeeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepository EmployeeRepository;
	
	@Autowired
	private ClockRegisterRepository ClockRegisterRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee e1 = new Employee(null, "Albert Einstein", "Science", "Scientist", 12313123, new BigDecimal(50000.37));
		Employee e2 = new Employee(null, "Erwin Schrodinger", "Science", "Scientist", 12313123, new BigDecimal(60000.37));
		Employee e3 = new Employee(null, "Julius Robert Oppenheimer", "Science", "Scientist", 12313123, new BigDecimal(20000.37));
		
		EmployeeRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		ClockRegister r1 = new ClockRegister(null, e3, new Timestamp(System.currentTimeMillis()));
		
		ClockRegisterRepository.save(r1);
	}

}
