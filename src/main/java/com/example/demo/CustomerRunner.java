package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerRunner implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(String... arg0) throws Exception {
		customerRepository.save(new Customer("1", "John", 101d));
		customerRepository.save(new Customer("2", "Ankur", 102d));
		customerRepository.save(new Customer("3", "Harry", 103d));
		
		customerRepository.findAll().forEach(System.out::println);
	}
}
