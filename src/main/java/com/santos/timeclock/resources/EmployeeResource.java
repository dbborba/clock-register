package com.santos.timeclock.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.santos.timeclock.entities.Employee;
import com.santos.timeclock.services.EmployeeService;

@RestController
@RequestMapping(value="/employees")
public class EmployeeResource {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<Employee>> findAll() {
		List<Employee> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value = "/insert")
	public ResponseEntity<Employee> insert(@RequestBody Employee obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
