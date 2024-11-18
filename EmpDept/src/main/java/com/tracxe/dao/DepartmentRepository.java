package com.tracxe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trx.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository <Department, Long> {
	
	@Query("from Department d WHERE d.deptName = :deptName")
	Department findByName(@Param("deptName") String deptName);
	
	Department findById( @Param ("deptId") long id);
	
	Department findByLocation(@Param("location") String location);

}
