package com.rms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.rms.dao.EmployeeDao;
import com.rms.model.Employee;
import com.rms.service.EmployeeServiceImpl;

@SpringBootTest
class EmployeeServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;

	@Mock
	EmployeeDao employeeDao;

	@Test
	public void addEmployeeDetails() {
		Employee emp = new Employee(1, "rutik", "rutik@gmail.com", "rutik@123", 771906446, "India", "1998-05-11", 24,
				"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "669339058797");
		when(employeeDao.save(emp)).thenReturn(emp);
		assertEquals(emp, employeeServiceImpl.addEmployee(emp));
	}

	@Test
	public void getAllEmployeeDetails() {
//		Employee emp = new Employee(1, "rutik", "rutik@gmail.com", "rutik@123", 771906446, "India", "1998-05-11", 24,
//				"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "669339058797");
		when(employeeDao.findAll()).thenReturn(Stream
				.of(new Employee(2, "ravi", "ravi@gmail.com", "ravi@123", 786645981, "India", "1999-02-21", 23,
						"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "6612339058797"),
						new Employee(1, "rohit", "rohit@gmail.com", "rohit@123", 771126446, "India", "1999-06-13", 24,
								"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "934339058797"))
				.collect(Collectors.toList()));
		assertEquals(2, employeeServiceImpl.viewAllEmployee().size());
	}

	@Test
	public void getEmployeeDetailsById() {
		Employee emp = new Employee(1, "rutik", "rutik@gmail.com", "rutik@123", 771906446, "India", "1998-05-11", 24,
				"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "669339058797");
		when(employeeDao.findById(emp.getEmpId())).thenReturn(Optional.of(emp));
		Employee empExpected = employeeServiceImpl.viewByEmpId(emp.getEmpId());
		verify(employeeDao).findById(emp.getEmpId());
	}

	@Test
	public void deleteEmployeeDetailsById() {
		Employee emp = new Employee(1, "rutik", "rutik@gmail.com", "rutik@123", 771906446, "India", "1998-05-11", 24,
				"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "669339058797");
		employeeDao.save(emp);
		employeeDao.deleteById(emp.getEmpId());
		Optional optional = employeeDao.findById(emp.getEmpId());
		assertEquals(Optional.empty(), optional);
	}

	@Test
	public void updateEmployeeDetailsById() {
		Employee emp = new Employee(1, "rutik", "rutik@gmail.com", "rutik@123", 771906446, "India", "1998-05-11", 24,
				"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "669339058797");
		Employee updateEmp = new Employee(1, "rutikmali", "rutikmali@gmail.com", "rutikmali@123", 942118823,
				"India", "1999-05-11", 23, "Not_approved", 0, "FSD", 26700, "java", "Chennai", 1, "6635639058797");
		when(employeeDao.findById(emp.getEmpId())).thenReturn(Optional.of(emp));
		employeeServiceImpl.updateByEmpId(updateEmp, 1);
		assertEquals(emp, employeeServiceImpl.viewByEmpId(1));
	}

	@Test
	public void getEmployeeBySkill() {

		List<Employee> all = new LinkedList<>();

		all.add(new Employee(1, "rutik", "rutik@gmail.com", "rutik@123", 771906446, "India", "1998-05-11", 24,
				"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "669339058797"));
		Employee emp = new Employee(1, "rutik", "rutik@gmail.com", "rutik@123", 771906446, "India", "1998-05-11", 24,
				"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "669339058797");

		when(employeeDao.findEmployeeBySkill("java")).thenReturn(all);
		assertEquals(all, employeeServiceImpl.findEmployeeBySkill("java"));
	}

	@Test
	public void getEmployeeByLocation() {

		List<Employee> all = new LinkedList<>();

		all.add(new Employee(1, "rutik", "rutik@gmail.com", "rutik@123", 771906446, "India", "1998-05-11", 24,
				"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "669339058797"));
		Employee emp = new Employee(1, "rutik", "rutik@gmail.com", "rutik@123", 771906446, "India", "1998-05-11", 24,
				"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "669339058797");

		when(employeeDao.findEmployeesByLocation("Hydrabad")).thenReturn(all);
		assertEquals(all, employeeServiceImpl.findEmployeesByLocation("Hydrabad"));
	}

	@Test
	public void getEmployeeByDepartment() {

		List<Employee> all = new LinkedList<>();

		all.add(new Employee(1, "rutik", "rutik@gmail.com", "rutik@123", 771906446, "India", "1998-05-11", 24,
				"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "669339058797"));
		Employee emp = new Employee(1, "rutik", "rutik@gmail.com", "rutik@123", 771906446, "India", "1998-05-11", 24,
				"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "669339058797");

		when(employeeDao.findEmployeesByDepartment("FSD")).thenReturn(all);
		assertEquals(all, employeeServiceImpl.findEmployeesByDepartment("FSD"));
	}

	@Test
	public void getEmployeeByExperince() {

		List<Employee> all = new LinkedList<>();

		all.add(new Employee(1, "rutik", "rutik@gmail.com", "rutik@123", 771906446, "India", "1998-05-11", 24,
				"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "669339058797"));
		Employee emp = new Employee(1, "rutik", "rutik@gmail.com", "rutik@123", 771906446, "India", "1998-05-11", 24,
				"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "669339058797");

		when(employeeDao.findEmployeeByExperince(1)).thenReturn(all);
		assertEquals(all, employeeServiceImpl.findEmployeesByExperince(1));
	}

	@Test
	public void updateAppraisalStatusByEmpId() {
		Employee emp = new Employee(1, "rutik", "rutik@gmail.com", "rutik@123", 771906446, "India", "1998-05-11", 24,
				"Not_approved", 0, "FSD", 25000, "java", "Hydrabad", 1, "669339058797");
		Employee updatedTransaction = new Employee(1, "rutikmali", "rutikmali@gmail.com", "rutikmali@123", 942118823,
				"India", "1999-05-11", 23, "Not_approved", 0, "FSD", 26700, "java", "Chennai", 1, "6635639058797");
		when(employeeDao.findById(emp.getEmpId())).thenReturn(Optional.of(emp));
		employeeServiceImpl.updateByEmpId(updatedTransaction, 1);
		assertEquals(emp, employeeServiceImpl.viewByEmpId(1));
	}

}
