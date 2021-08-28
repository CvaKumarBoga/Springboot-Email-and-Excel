package com.app.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	/*
	 * @Query("SELECT e.name FROM Employee e where e.status:?1") public List<String>
	 * getEmployeeNames(String name);
	 */

}
