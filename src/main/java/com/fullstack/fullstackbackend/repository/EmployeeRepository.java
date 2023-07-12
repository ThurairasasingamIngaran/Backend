package com.fullstack.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.fullstackbackend.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
