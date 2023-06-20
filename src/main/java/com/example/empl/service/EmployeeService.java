package com.example.empl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empl.entity.EmployeeEntity;
import com.example.empl.model.Employee;
import com.example.empl.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findAll()
	{
		List<EmployeeEntity> employeeEntityList=employeeRepository.findAll();
		List<Employee> employeeList=new ArrayList<>();
		for(EmployeeEntity emp:employeeEntityList)
		{
			employeeList.add(new Employee(emp));
		}
		return employeeList;
		
	}
	
	public Employee findById(int id) throws Exception
	{
		Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(id);
		if(employeeEntity.isPresent())
		{
			return new Employee(employeeEntity.get());
		}
		else
		{
			throw new Exception("Employee details not found by id "+id);
		}
	}
	
	public Employee saveEmployee(Employee employee)
	{
		EmployeeEntity employeeEntity=employeeRepository.save(new EmployeeEntity(employee));
		
		return new Employee(employeeEntity);
		
	}

}
