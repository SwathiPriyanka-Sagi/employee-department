package com.entity.EmpDept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracxe.dao.DepartmentDAO;
import com.trx.model.Department;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentDAO deptdao;
	
	@RequestMapping("/deptById/{deptId}")
	public Department getDepartmentById(@PathVariable ("deptId") long deptId) {
		return deptdao.getDepartmentById(deptId);
	}
	
	@RequestMapping("/deptBydeptName/{deptName}")
	public Department getDepartmentByName(@PathVariable("deptName") String deptName) {
		return deptdao.getDepartmentByName(deptName);
	}
	
	@RequestMapping("/deptBydeptLocation/{location}")
	public Department getDepartmentByLocation(@PathVariable("location") String Location) {
		return deptdao.getDepartmentByLocation(Location);
	}
}
