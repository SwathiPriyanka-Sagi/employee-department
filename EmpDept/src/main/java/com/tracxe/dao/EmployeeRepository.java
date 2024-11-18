package com.tracxe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trx.model.Department;
import com.trx.model.Employee;
import com.trx.model.EmployeeDTO;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
	
	@Query("from Employee e WHERE e.empName = :empName")
	Employee findByName(@Param("empName") String empName);
	
	EmployeeDTO findEmployeeByDepartment(  Department department);
}
