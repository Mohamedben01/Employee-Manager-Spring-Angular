package com.web.app.service;

import java.util.List;

import com.web.app.model.Employee;

public interface EmployeeService {

	
	Employee addEmployee(Employee employee);
	
	Employee findEmployeeById(Long id);
	
	List<Employee> listEmployees();
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployee(Long id);
}
