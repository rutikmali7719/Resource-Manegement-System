package com.rms.service;

import java.util.List;

import com.rms.model.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	public List<Employee> viewAllEmployee();
	public Employee viewByEmpId(int empId);
	public Employee updateByEmpId(Employee employee, int empId);
	public void deleteByEmpId(int empId);
	public String updateAppraisalStatusByEmpId(int empId);
	public String getAppraisalStatusByEmpId(int empId);
	public List<Employee> findEmployeeBySkill(String skill);
	public List<Employee> findEmployeesByLocation(String location);
	public List<Employee> findEmployeesByDepartment(String department);
	public List<Employee> findEmployeesByExperince(int experince);
	
	
}

