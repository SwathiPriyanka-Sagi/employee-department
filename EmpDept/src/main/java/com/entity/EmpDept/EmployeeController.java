package com.entity.EmpDept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracxe.dao.DepartmentDAO;
import com.tracxe.dao.EmployeeDAO;
import com.trx.model.Department;
import com.trx.model.Employee;
import com.trx.model.EmployeeDTO;
import com.trx.model.Product;

@CrossOrigin(origins="*")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO empDAO;
	@Autowired
	private DepartmentDAO deptDao;
	
	@RequestMapping("/EmployeeById/{ID}")
    public Employee getEmployeeById(@PathVariable("ID")int id) {
    	return empDAO.getEmpById(id);
    }
	
	@RequestMapping("/empByEmployeeName/{empName}")
	public Employee getEmployeeByName(@PathVariable("empname")String empName) {
		return empDAO.getEmpByName(empName);
	}
	
//	@PostMapping("/registerEmployee")
//	public Employee registerEmployee(@RequestBody Employee Employee) {
//		return empDAO.registerEmployee(Employee);
//	}
	
	@DeleteMapping("/deleteEmployee/{ID}")
	public String deleteEmployeeById(@PathVariable("ID")int id) {
		empDAO.deleteEmployeeById(id);
		return "employee with id: " + id + "is deleted";
	}
	@PostMapping("/registerEmployee")
	public Employee registerEmployee(@RequestBody EmployeeDTO employeedto) {
		Employee emp = new Employee(employeedto.getEmpId(), employeedto.getEmpName(), employeedto.getSalary(), employeedto.getGender(), employeedto.getDoj(), employeedto.getEmail(), employeedto.getPassword());
		Department dprt = deptDao.getDepartmentById(employeedto.getDeptId());
		emp.setDepartment(dprt);
		return empDAO.registerEmployee(emp);
	}
	
	@RequestMapping("/getEmployeeByDepartment")
	public EmployeeDTO getEmployeeBydepyId( @RequestBody Department department) {
		return empDAO.getEmpByDept(department);
	}
	
	

}
