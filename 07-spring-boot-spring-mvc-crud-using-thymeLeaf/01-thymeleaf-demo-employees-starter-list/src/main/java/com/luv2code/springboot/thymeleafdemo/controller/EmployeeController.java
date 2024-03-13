package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService theEmployeeService;
	@Autowired
	public EmployeeController(EmployeeService employeeService){
		theEmployeeService = employeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> theEmployees = theEmployeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		Employee employee = new Employee();
		theModel.addAttribute("employee", employee);
		return "employees/employee-form";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theID ,Model theModel){
		Employee employee = theEmployeeService.findById(theID);
		theModel.addAttribute("employee", employee);
		return "employees/employee-form";
	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
		theEmployeeService.save(theEmployee);
		return "redirect:/employees/list"; //to prevent duplicate submissions in case user hit reload button we use "post/redirect/get" pattern
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theID){
		theEmployeeService.deleteById(theID);
		return "redirect:/employees/list";
	}
}









