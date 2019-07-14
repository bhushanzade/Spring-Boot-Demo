package com.example.springapi.service;

import java.util.List;

import com.example.springapi.detail.employee;

public interface employeeService {

	employee getEmployeeById(int emp_id);
	void addEmployee(employee emp);
	void updateEmployee(employee emp, int emp_id);
	void deleteEmployee(int emp_id);
	List<employee> getAllEmployee();
}	
