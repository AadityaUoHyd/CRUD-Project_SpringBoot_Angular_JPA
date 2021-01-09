package com.aadi.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadi.boot.exception.ResourceNotFoundException;
import com.aadi.boot.model.Employee;
import com.aadi.boot.repository.EmployeeRepository;

@CrossOrigin                                    //(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository  employeeRepository;
	
	//Get all employees
	@GetMapping("/employees")
	public List<Employee> grtAllEmployee(){
		return employeeRepository.findAll();
	}
	
	//create employee rest api
	@PostMapping("/employees")
		public Employee createEmployee(@RequestBody Employee employee) {
			return employeeRepository.save(employee);
		}
	
	//Get Employee by Id REST API
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow( ()-> new ResourceNotFoundException("Employeenot exist with ID : "+id));
		return ResponseEntity.ok(employee);
	}
	
	//Update Employee REST API
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee (@PathVariable Long id, @RequestBody Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow( ()-> new ResourceNotFoundException("Employeenot exist with ID : "+id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());
		employee.setMobile(employeeDetails.getMobile());
		
		Employee updateEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updateEmployee);
	}
	
	//Delete Employee REST API
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow( ()-> new ResourceNotFoundException("Employeenot exist with ID : "+id));
		employeeRepository.delete(employee);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}