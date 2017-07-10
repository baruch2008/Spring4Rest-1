package com.javahash.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.javahash.spring.dao.EmployeeRepository;
import com.javahash.spring.model.Employee;
import com.javahash.spring.service.IEmployeesService;

public class EmployeesServiceImpl implements IEmployeesService {
	
	@Autowired
	private EmployeeRepository repository;

	public Iterable<Employee> findEmployeeByName(String name) {
		return repository.findEmployeesByName(name);
	}

	public Employee findEmployeeById(String id) {
		return repository.findEmployeeById(id);
	}

	public Iterable<Employee> findAll() {
		return repository.findAll();
	}

	public void create(Employee employee) {
		Employee emp = repository.save(employee);
	}

	public void delete(String id) {
		repository.delete(id);		
	}

}
