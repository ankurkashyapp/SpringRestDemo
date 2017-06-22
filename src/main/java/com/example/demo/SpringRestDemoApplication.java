package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@SpringBootApplication
public class SpringRestDemoApplication {

	@Autowired
	EmployeeService employeeService;
	
	@Bean
	public CommandLineRunner setEmployeeRepository(@Autowired EmployeeRepository employeeRepository) {
		CommandLineRunner runner = (args) -> {
			employeeRepository.save(new Employee(1, "Ankur", 100d));
			employeeRepository.save(new Employee(2, "John", 200d));
			employeeRepository.save(new Employee(3, "Smith", 300d));
			employeeRepository.save(new Employee(4, "Ankur", 400d));
			employeeRepository.save(new Employee(5, "Ankur", 500d));
			
			List<Employee> employee = employeeRepository.findByName("Ankur");
			System.out.println("Employee name: " + employee.get(0).getName());
			System.out.println("Employee name2: " + employeeService.getAllEmployees().get(1).getName());
			//employeeService.delete(4);
			employeeService.getAllEmployeesByName("Ankur").forEach(emp -> {
				System.out.println(emp.getName() + " : " + emp.getSalary());
			});
		};
		
		return runner;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringRestDemoApplication.class, args);
	}
}
