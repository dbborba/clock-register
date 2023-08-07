package com.santos.timeclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santos.timeclock.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
