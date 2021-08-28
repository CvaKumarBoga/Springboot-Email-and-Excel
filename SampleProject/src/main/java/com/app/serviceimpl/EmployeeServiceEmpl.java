package com.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Employee;
import com.app.repo.EmployeeRepository;
import com.app.service.EmployeeService;

@Service
public class EmployeeServiceEmpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	@Transactional
	public Integer saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		e=repo.save(e);
		return e.getId() ;
	}
	@Override
	@Transactional(readOnly = true)
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> byId = repo.findById(id);
		if(byId.isPresent()) {
			return byId.get();
		}
		return null;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}
	
	@Override
	public Employee getNames(String name) {
		return null;
	}
	
	@Override
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
	}
	
	/*
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public Employee getNames(String name) { //
	 * TODO Auto-generated method stub List<Employee> names =
	 * repo.getEmployeeNames(name); return (Employee) names; }
	 */
}
