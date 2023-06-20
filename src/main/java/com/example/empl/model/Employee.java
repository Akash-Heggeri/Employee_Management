package com.example.empl.model;

import java.util.Objects;

import com.example.empl.entity.EmployeeEntity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Employee 
{
	private Integer id;
	private String name;
	private String Department;
	private String email;

	
	
	public Employee() {
		super();
	}

	public Employee(EmployeeEntity employeeEntity) {
		super();
		this.setId(employeeEntity.getId());
		this.setName(employeeEntity.getName());
		this.setDepartment(employeeEntity.getDepartment());
		this.setEmail(employeeEntity.getEmail());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash( id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals( id , other.id) && Objects.equals(email, other.email);
		
	}

}
