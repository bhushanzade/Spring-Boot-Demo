package com.example.springapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springapi.detail.employee;

@Service
public class SpringServices implements employeeService{
	List<employee> empList =new ArrayList<> (Arrays.asList(
			new employee(1,"Bhushan","Computer Engineer"),
			new employee(2,"Amit","Aggreeculture Engineer"),
			new employee(3,"Pratik","Aggreeculture Engineer")));

	@Override
	public List<employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empList;
	}

	@Override
	public employee getEmployeeById(int emp_id) {
		// TODO Auto-generated method stub
		return empList.stream().filter(e->e.getEmp_id()== emp_id).findFirst().get();
	}

	@Override
	public void addEmployee(employee emp) {
		// TODO Auto-generated method stub
		empList.add(emp);
	}

	@Override
	public void updateEmployee(employee emp, int emp_id) {
		int no = empList.size();
		for(int i=1;i<=no;i++) {
			employee e = empList.get(i);
			if(e.getEmp_id()==emp_id) {
				empList.set(i, emp);
				return;
			}
		}
	}

	@Override
	public void deleteEmployee(int emp_id) {
		// TODO Auto-generated method stub
		
		empList.removeIf(e -> e.getEmp_id() == emp_id);
		
	}


}
