package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	public void saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public void delete(int empId);
	
	public Employee getEmployeeById(int empId);
	
	public List<Employee> getAllEmployeesByName(String name);
}
