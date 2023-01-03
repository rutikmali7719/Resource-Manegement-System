package com.rms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rms.model.Employee;
import com.rms.service.EmployeeService;

@RestController
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployeeDetails")
	public Employee addEmployee(@RequestBody Employee employee) {
		logger.info("In addEmployess Controller {}", employee);

		return employeeService.addEmployee(employee);
	}

	@GetMapping("/getAllEmployeeDetails")
	public List<Employee> viewAllEmployee() {
		logger.info("In viewAllEmployee Controller {}");

		return employeeService.viewAllEmployee();
	}

	
	@GetMapping("/getEmployeeDetailsById/{empId}")
	public Employee viewEmployeeById(@PathVariable int empId) {
		logger.info("In viewAllEmployeeById Controller {}",empId);

		return employeeService.viewByEmpId(empId);
	}

	@DeleteMapping("/deleteEmployeeDetailsById/{empId}")
	public void deleteById(@PathVariable int empId) {
		logger.info("In deleteEmployee Controller {}",empId);

		employeeService.deleteByEmpId(empId);

	}

	@PutMapping("/updateEmployeeDetailsById/{empId}")
	public Employee updateEmployeeById(@RequestBody Employee employee,@PathVariable int empId) {
		logger.info("In updateEmployee Controller data{} Id{}",employee,empId);

		return employeeService.updateByEmpId(employee, empId);

	}

	@GetMapping("/getEmployeeBySkill/{skill}")
	public List<Employee> viewEmployeeBySkill(@PathVariable String skill) {
		logger.info("In findEmployeeBySkill Service {}",skill);

		return employeeService.findEmployeeBySkill(skill);
	}

	@GetMapping("/getEmployeeByLocation/{location}")
	public List<Employee> viewEmployeeByLocation(@PathVariable String location) {
		logger.info("In findEmployeeByLocation Controller {}",location);

		return employeeService.findEmployeesByLocation(location);

	}

	@GetMapping("/getEmployeeByDepartment/{department}")
	public List<Employee> viewEmployeeByDepartment(@PathVariable String department) {
		logger.info("In findEmployeeByDepartment Controller {}",department);

		return employeeService.findEmployeesByDepartment(department);
	}

	@GetMapping("/getEmployeeByExperince/{experince}")
	public List<Employee> viewEmployeeByExperince(@PathVariable int experince) {
		logger.info("In findEmployeeByExperince Controller {}",experince);

		return employeeService.findEmployeesByExperince(experince);
	}
	
	@GetMapping("/getAppraisalStatus/{empId}")
	public String getAppraisalStatusByEmpId(@PathVariable int empId) {
		logger.info("In updateAppraisalStatusByEmpId Controller {}",empId);

		return employeeService.getAppraisalStatusByEmpId(empId);
		
	}
	@PutMapping("/updateAppraisalStatusByEmpId/{empId}")
	public String updateAppraisalStatusByEmpId(@PathVariable int empId) {
		
		logger.info("In getAppraisalStatusByEmpId Controller {}",empId);

		return employeeService.updateAppraisalStatusByEmpId(empId);
		
	}

}
