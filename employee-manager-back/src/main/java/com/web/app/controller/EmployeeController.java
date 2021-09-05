package com.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.model.Employee;
import com.web.app.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}


	@GetMapping(value="/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		try {
			List<Employee> employees = this.employeeService.listEmployees();
			return new ResponseEntity<>(employees, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		try {
			Employee employee =  this.employeeService.findEmployeeById(id);
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		try {
			Employee newEmployee = this.employeeService.addEmployee(employee);
			return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		try {
			Employee updateEmployee = this.employeeService.updateEmployee(employee);
			return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
		try {
			this.employeeService.deleteEmployee(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
