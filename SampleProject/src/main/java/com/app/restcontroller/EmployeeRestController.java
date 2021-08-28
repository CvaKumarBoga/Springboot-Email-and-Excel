package com.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeRestController {

	@Autowired
	private EmployeeService service;

	@GetMapping("msg")
	public String msg() {
		return "Hello!..Sivakumar Boga";
	}
	@PostMapping("create")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		ResponseEntity<String> resp = null;
		try {
			Integer emp = service.saveEmployee(employee);
			resp = new ResponseEntity<>("Employe created succesfully!..",HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	@GetMapping("get/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable("id") Integer id) {
		ResponseEntity<?> resp = null;
		try {
			Employee employee = service.getOneEmployee(id);
			if(employee!=null)
				resp = new ResponseEntity<Employee>(employee,HttpStatus.OK);
			else
				resp = new ResponseEntity<String>("Employee not found...",HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	@GetMapping("all")
	public ResponseEntity<?> getAllEmployees(){
		ResponseEntity<?> resp = null;
		try {
			List<Employee> list = service.getAllEmployee();
			if(list!=null)
				resp = new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
			else
				resp = new ResponseEntity<String>("Data is not found..",HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		ResponseEntity<?> resp = null;
		try {
			if(id!=null) {
				service.deleteEmployee(id);
				resp = new ResponseEntity<String>("Employee deleted succesfully",HttpStatus.OK);
			}
			else {
				resp = new ResponseEntity<String>("Data is found...",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
}
