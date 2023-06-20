package com.example.empl.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.empl.model.Employee;
import com.example.empl.service.EmployeeService;

@RestController
@RequestMapping("employee/")
public class EmployeeAPIController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("all")
	//@RequestMapping(value="all",method=RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		try {
			List<Employee> employeeList=employeeService.findAll();
			return new ResponseEntity<>(employeeList, HttpStatus.OK);
			
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
			
		}
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
	{
		try{
			Employee getEmployee=employeeService.findById(id);
			return new ResponseEntity<>(getEmployee, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		}
	}
	
	
	@PostMapping("save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		try {
			
			Employee savedEmployee=employeeService.saveEmployee(employee);
			return new ResponseEntity<>(savedEmployee,HttpStatus.OK);
			
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		}
	}
	
}
