package com.tracxe.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trx.model.Department;

@Service
public class DepartmentDAO {
	@Autowired
	private DepartmentRepository deptRepo;
	
	public List<Department> getAllDepartment() {
		return deptRepo.findAll();
	}
	
	public Department getDepartmentById(long deptId) {
		return deptRepo.findById(deptId);
	}
	public Department getDepartmentByName(String deptName) {
		return deptRepo.findByName(deptName);
	}
	
	public Department getDepartmentByLocation(String location) {
		return deptRepo.findByLocation(location);
	}
}
