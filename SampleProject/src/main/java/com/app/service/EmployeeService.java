package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface EmployeeService {
	
	public Integer saveEmployee(Employee e);
	public List<Employee> getAllEmployee();
	public Employee getOneEmployee(Integer id);
	public void deleteEmployee(Integer id);
	
	public Employee getNames(String name);
	

}
