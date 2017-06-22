package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@Scope("request")
@RequestMapping("/rest/employees")
public class EmployeeRestController {

	@Autowired
	@Qualifier("employeeServiceImpl")
	private EmployeeService employeeService;

	@RequestMapping(value = "/insert/{id}/{name}/{salary}", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void insertEmployee(@PathVariable("id") int empId, @PathVariable("name") String name, @PathVariable("salary") Double salary) {
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setName(name);
		employee.setSalary(salary);
		employeeService.saveEmployee(employee);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = { "application/json", "application/xml" })
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
	}
	
	@RequestMapping(value = "/{empid}", method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteEmployee(@PathVariable("empid") int empId) {
		employeeService.delete(empId);
	}
	
	@RequestMapping(value = "/{empid}", method = RequestMethod.GET, produces = { "application/json", "application/xml"})
	@ResponseStatus(code = HttpStatus.OK)
	public Employee getEmployeeById(@PathVariable("empid") int empId) {
		return employeeService.getEmployeeById(empId);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = { "application/json", "application/xml"})
	@ResponseStatus(code = HttpStatus.OK)
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(value = "/search/{name}", method = RequestMethod.GET, produces = { "application/json", "application/xml"})
	@ResponseStatus(code = HttpStatus.OK)
	public List<Employee> getEmployeesByName(@PathVariable("name") String name) {
		return employeeService.getAllEmployeesByName(name);
	}
}
