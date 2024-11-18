package com.tracxe.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trx.model.Department;
import com.trx.model.Employee;
import com.trx.model.EmployeeDTO;
import com.trx.model.Product;

@Service
public class EmployeeDAO {
	@Autowired
	private EmployeeRepository empRepo;
	
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}
	
	public Employee getEmpById(int id) {
		return empRepo.findById(id).orElse(new Employee());
	} 
	
	public Employee getEmpByName(String empName) {
		return empRepo.findByName(empName);
	}
	
	public Employee registerEmployee(Employee employee) {
		return empRepo.save(employee);
	}
	
	public String deleteEmployeeById(int id) {
		empRepo.deleteById(id);
		return "employee with id: " + id + "is deleted";
	}
	
	public EmployeeDTO getEmpByDept(Department department) {
		return empRepo.findEmployeeByDepartment(department);
	}
}
