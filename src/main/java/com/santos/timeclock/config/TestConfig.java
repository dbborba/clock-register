package com.santos.timeclock.config;

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
		Employee e1 = new Employee(null, "Albert Einstein", "Science", "Scientist", 12313123, 50.00);
		Employee e2 = new Employee(null, "Erwin Schrodinger", "Science", "Scientist", 12313123, 40.00);
		Employee e3 = new Employee(null, "Julius Robert Oppenheimer", "Science", "Scientist", 12313123, 30.00);
		
		EmployeeRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		ClockRegister r1 = new ClockRegister(null, e1, Timestamp.valueOf("2023-08-22 14:00:05.992"));
		ClockRegister r2 = new ClockRegister(null, e1, Timestamp.valueOf("2023-08-22 22:00:05.992"));
		ClockRegister r3 = new ClockRegister(null, e1, Timestamp.valueOf("2023-08-23 14:00:05.992"));
		ClockRegister r4 = new ClockRegister(null, e1, Timestamp.valueOf("2023-08-23 22:00:05.992"));
		ClockRegister r5 = new ClockRegister(null, e1, Timestamp.valueOf("2023-08-24 14:00:05.992"));
		ClockRegister r6 = new ClockRegister(null, e1, Timestamp.valueOf("2023-08-24 22:00:05.992"));
		
		ClockRegisterRepository.saveAll(Arrays.asList(r1, r2, r3, r4, r5, r6));
	}

}
