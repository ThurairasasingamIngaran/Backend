package com.fullstack.fullstackbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.fullstackbackend.entities.Employee;
import com.fullstack.fullstackbackend.repository.EmployeeRepository;

@RestController
@CrossOrigin("http://localhost:3000/")
public class EmployeeController {
@Autowired
private EmployeeRepository employeeRepository;

@PostMapping("/employee")
Employee newEmployee(@RequestBody Employee newEmployee)
{
	return employeeRepository.save(newEmployee);
}
@GetMapping("/employees")
java.util.List<Employee>getAllEmployees(){
	return employeeRepository.findAll();
}
}
