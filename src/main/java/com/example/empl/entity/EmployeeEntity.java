package com.example.empl.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.empl.model.Employee;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name="EMP")
public class EmployeeEntity 
{
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name;
	@Column
	private String Department;
	@Column
	private String email;
	
	
	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeEntity(Employee employee) {
		super();
		this.setId(employee.getId());
		this.setName(employee.getName());
		this.setDepartment(employee.getDepartment());
		this.setEmail(employee.getEmail());
	}

	


	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeEntity other = (EmployeeEntity) obj;
		return Objects.equals( id , other.id) && Objects.equals(email, other.email);
	}

	
	
	
	
}
