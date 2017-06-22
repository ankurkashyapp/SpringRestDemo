package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@Override
	public void saveEmployee(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public void delete(int empId) {
		employeeRepo.delete(empId);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return employeeRepo.findOne(empId);
	}

	@Override
	public List<Employee> getAllEmployeesByName(String name) {
		return employeeRepo.findByName(name);
	}

}
