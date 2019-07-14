package com.example.springapi.detail;

public class employee {
	private int emp_id;
	private String emp_name;
	private String emp_dprt;
	
	
	public employee(int emp_id, String emp_name, String emp_dprt) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_dprt = emp_dprt;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_dprt() {
		return emp_dprt;
	}
	public void setEmp_dprt(String emp_dprt) {
		this.emp_dprt = emp_dprt;
	}
	
}
