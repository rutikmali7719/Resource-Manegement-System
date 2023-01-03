package com.rms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.rms.dao.EmployeeDao;
import com.rms.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Employee addEmployee(Employee employee) {
		logger.info("In addEmployess Service");

		return employeeDao.save(employee);
//	public String addEmployee(Employee employee) {
//		if (!employee.getAdhaarNo().isEmpty()) {
//			List<Employee> list = employeeDao.findAll();
//			boolean isPresent = false;
//			for (Employee employeeDB : list) {
//				if (employee.getAdhaarNo().equals(employeeDB.getAdhaarNo())) {
//					isPresent = true;
//					break;
//				}
//			}
//			if (isPresent) { 
//				return "This Adhaar Card Number already exist";
//			} else {
//				employeeDao.save(employee);
//				return "Successfully Saved Employee Details";
//			}
//		} else
//			return "Invaild Input";

	}

	@Override
	public List<Employee> viewAllEmployee() {
		logger.info("In viewAllEmployee Service");

		return employeeDao.findAll();
	}

	@Override
	public Employee viewByEmpId(int empId) {
		logger.info("In viewAllEmployeeById Service");

		return employeeDao.findById(empId).get();
	}

	@Override
	public Employee updateByEmpId(@RequestBody Employee employee, @PathVariable int empId) {
		logger.info("In updateEmployee Service");

		Employee employeeupdate = employeeDao.findById(empId).get();
		employeeupdate.setEmpname(employee.getEmpname());
		employeeupdate.setEmail(employee.getEmail());
		employeeupdate.setPassword(employee.getPassword());
		employeeupdate.setPhoneNo(employee.getPhoneNo());
		employeeupdate.setCountry(employee.getCountry());
		employeeupdate.setAge(employee.getAge());
		employeeupdate.setAppraisalStatus(employee.getAppraisalStatus());
//		employeeupdate.setAppraisalAmount(employee.getAppraisalAmount());
		employeeupdate.setDepartment(employee.getDepartment());
		employeeupdate.setSkill(employee.getSkill());
		employeeupdate.setLocation(employee.getLocation());
		employeeupdate.setExperince(employee.getExperince());
		employeeupdate.setAdhaarNo(employee.getAdhaarNo());
		return employeeDao.save(employeeupdate);

	}

	@Override
	public void deleteByEmpId(int empId) {
		logger.info("In deleteEmployee Service");

		employeeDao.deleteById(empId);
	}

	@Override
	public List<Employee> findEmployeeBySkill(String skill) {
		logger.info("In findEmployeeBySkill Service");

		return employeeDao.findEmployeeBySkill(skill);
	}

	@Override
	public List<Employee> findEmployeesByLocation(String location) {
		logger.info("In findEmployeeByLocation Service");

		return employeeDao.findEmployeesByLocation(location);
	}

	@Override
	public List<Employee> findEmployeesByDepartment(String department) {
		logger.info("In findEmployeeByDepartment Service");

		return employeeDao.findEmployeesByDepartment(department);
	}

	@Override
	public List<Employee> findEmployeesByExperince(int experince) {
		logger.info("In findEmployeeByExperince Service");

		return employeeDao.findEmployeeByExperince(experince);
	}

	@Override
	public String updateAppraisalStatusByEmpId(int empId) {
		logger.info("In updateAppraisalStatusByEmpId Service");
		Employee emp = this.employeeDao.findById(empId).get();
		emp.setAppraisalStatus("approve");
		double salary = emp.getSalary();
		emp.setSalary(salary + (salary * 0.3));
		employeeDao.save(emp);
		return "Appraisal Status Updated Succesfully";

	}

	@Override
	public String getAppraisalStatusByEmpId(int empId) {
		logger.info("In getAppraisalStatusByEmpId Service");
		Employee emp = this.employeeDao.findById(empId).orElse(null);
		return emp.getAppraisalStatus();
	}

}
