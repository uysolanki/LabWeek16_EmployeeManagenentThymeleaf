package com.greatlearning.EmployeeManagement.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.EmployeeManagement.entity.Employee;
import com.greatlearning.EmployeeManagement.service.EmployeeServiceImpl;

// BE --> FE Model
// FE --> BE @ModelAttribute
@Controller
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeservice;
	
	private static final Logger logger=Logger.getLogger(EmployeeController.class);
	
	@GetMapping("/employees")
	public String listemployees(Model model)
	{
		logger.info("View All Employees Invoked");
		List<Employee> emplist=employeeservice.getAllEmployees();
		model.addAttribute("employees",emplist);
		logger.info("View All Employees Completed");
		return "employees";
		
	}
	
	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model)
	{
		logger.info("Create Employee Employee Form Invoked");
		Employee e1=new Employee();
		model.addAttribute("employee",e1);
		return "create_employee";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable int id,Model model)
	{
		Employee empdb=employeeservice.getEmployeeById(id);
		model.addAttribute("employee",empdb);
		return "edit_employee";
	}
	
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		employeeservice.deleteEmployeeById(id);
		return "redirect:/employees";
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee e1)
	{
		employeeservice.saveEmployee(e1);
		return "redirect:/employees";
	}
	
	
	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable int id,@ModelAttribute("employee") Employee newvalues)
	{
		Employee empdb=employeeservice.getEmployeeById(id);
		empdb.setFirstName(newvalues.getFirstName());
		empdb.setLastName(newvalues.getLastName());
		empdb.setEmail(newvalues.getEmail());
		employeeservice.updateEmployee(empdb);
		return "redirect:/employees";
	}
}
