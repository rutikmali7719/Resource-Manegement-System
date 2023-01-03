package com.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	public String getAppraisalStatusByEmpId(int empId);

	public List<Employee> findEmployeeBySkill(String skill);

	public List<Employee> findEmployeesByLocation(String location);

	public List<Employee> findEmployeesByDepartment(String department);

	public List<Employee> findEmployeeByExperince(int experince);
}