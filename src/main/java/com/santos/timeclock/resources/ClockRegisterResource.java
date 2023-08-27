package com.santos.timeclock.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.santos.timeclock.DTO.SalaryCalculationRequest;
import com.santos.timeclock.entities.ClockRegister;
import com.santos.timeclock.services.ClockRegisterService;

@RestController
@RequestMapping(value="clock-register")
public class ClockRegisterResource {
	
	@Autowired
	public ClockRegisterService service;
	
	@GetMapping
	public ResponseEntity<List<ClockRegister>> findAll() {
		List<ClockRegister> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value = "/insert")
	public ResponseEntity<ClockRegister> insert(@RequestBody String stringId) {
		ClockRegister register = service.insert(stringId);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(register.getId()).toUri();
		return ResponseEntity.created(uri).body(register);
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<ClockRegister>> list(@RequestBody String id) {
		List<ClockRegister> list = service.list(id);		
		return ResponseEntity.ok().body(list);
	}
	
	@DeleteMapping (value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/calculate")
	public ResponseEntity<Double> calculate(@RequestBody SalaryCalculationRequest request) {
		Double salary = service.calculateSalary(request.getId(), request.getYear(), request.getMonth());
		return ResponseEntity.ok().body(salary);
	}

}
