package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@CrossOrigin(origins="http://localhost:4200")
//@CrossOrigin(origins="chrome-extension://dgkahgnanakhlgjkeefeddoeoinbobbk/index.html")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	// get all employess
	@GetMapping("/employees")
	
	public List<Employee> getAllEmployees()
	{ 
		return employeeRepository.findAll();
	}
	
	// create employee rest api 
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		System.out.println("First Name:"+employee.getFirstName());
		
		return employeeRepository.save(employee);
	}
}
