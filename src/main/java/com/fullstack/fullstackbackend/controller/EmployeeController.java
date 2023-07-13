package com.fullstack.fullstackbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.fullstackbackend.entities.Employee;
import com.fullstack.fullstackbackend.exception.EmployeeNotFoundException;
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
@GetMapping("/employee/{id}")
Employee getEmployeeById(@PathVariable Long id) {
return employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
}

@PutMapping("/employee/{id}")
Employee updateEmployee(@RequestBody Employee newEmployee,@PathVariable Long id) {
	return employeeRepository.findById(id)
			.map(employee ->{
				employee.setUsername(newEmployee.getUsername());
				employee.setName(newEmployee.getName());
				employee.setEmail(newEmployee.getEmail());
				return employeeRepository.save(employee);
	}).orElseThrow(()->new EmployeeNotFoundException(id));
}
@DeleteMapping("/employee/{id}")
String deleteemployee(@PathVariable Long id) {
	if(!employeeRepository.existsById(id)) {
		throw new EmployeeNotFoundException(id);
	}
	employeeRepository.deleteById(id);
	return "Employee with id "+id+" has been deleted success.";
}
}
