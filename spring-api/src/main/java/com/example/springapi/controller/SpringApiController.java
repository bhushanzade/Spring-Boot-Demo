package com.example.springapi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapi.detail.employee;
import com.example.springapi.service.employeeService;

@RestController

public class SpringApiController {
	
	@Autowired
	employeeService empRef;
	
	@RequestMapping("/welcome")
	public String welcomeSpringApi() {
		return "Hello Spring I am really love u spring but u r not stronger than django.";
	}

	@RequestMapping("/employees")
	public List<employee> getAllEmployee(){
		return empRef.getAllEmployee();
	}
	
	@RequestMapping("/employees/{emp_id}")
	public employee getEmployeeById(@PathVariable int emp_id) {
		return empRef.getEmployeeById(emp_id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employees" )
	public void addEmployee(@RequestBody employee emp) {
		empRef.addEmployee(emp);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/employees/{emp_id}" )
	public void updateEmployee(@RequestBody employee emp, @PathVariable int emp_id) {
		empRef.updateEmployee(emp,emp_id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employees/{emp_id}" )
	public void deleteEmployee(@PathVariable int emp_id){
		empRef.deleteEmployee(emp_id);
	}
}
