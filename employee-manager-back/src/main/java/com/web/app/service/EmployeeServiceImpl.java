package com.web.app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.app.model.Employee;
import com.web.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	
	@Override
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return this.employeeRepository.save(employee);
	}

	@Override
	public List<Employee> listEmployees() {
		return this.employeeRepository.findAll();
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}


	@Override
	public void deleteEmployee(Long id) {
		this.employeeRepository.deleteById(id);
	}


	@Override
	public Employee findEmployeeById(Long id) {
		return this.employeeRepository.findById(id).get();
	}

}
