package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.excel.EmployeeExcelView;
import com.app.model.Employee;
import com.app.service.EmployeeService;
import com.app.util.EmailUtil;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@Autowired
	private EmailUtil util;

	@RequestMapping("/show")
	public String showPage(Model map) {
		map.addAttribute("employee", new Employee());
		return "EmployeePage";
	}

	// 1.Save employee
	// 2.Avoid duplicate employees in database
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Employee employee, Model map) {

		service.saveEmployee(employee);

		map.addAttribute("msg", "Employee '" + employee.getName() + "' saved succesfully");
		map.addAttribute("employee", new Employee());

		String msg ="and ";
		String text = "Hello " + employee.getName() + 
				", \nWelcome to empoyee registration... \nYour email is "+ employee.getEmail() + 
				", your salary is "+employee.getSalary()+ 
				" and your status is " + employee.getStatus()+".";
		
		boolean flag = util.sendEmail(employee.getEmail(), "Welcome to employee registration", text);
		if (flag)
			msg += " Email is send";
		else
			msg += " Email is not send";
		map.addAttribute("message", msg);

		return "EmployeePage";
	}

	@RequestMapping(value="/getone")
	public String getEmployee(@ModelAttribute @RequestParam("id") Integer id,Model map) {
		Employee one = service.getOneEmployee(id); 
		String str="The Employee data is not found"; 
		if(one!=null) {
			map.addAttribute("list", one); 
		}
		else { 
			map.addAttribute("msg", str);
		}
		return "GetData";
	}

	@RequestMapping(value = "/get")
	public String getStatusEmployees(Model map) {
		List<Employee> obj = service.getAllEmployee();
		map.addAttribute("list", obj);
		return "EmployeeStatus";
	}

	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Employee> obs = service.getAllEmployee();
		ModelAndView m = new ModelAndView();
		m.setView(new EmployeeExcelView());
		m.addObject("list", obs);
		return m;
	}

}
