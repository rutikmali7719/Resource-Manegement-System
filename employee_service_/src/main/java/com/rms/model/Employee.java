package com.rms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
public class Employee {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String empname;
	private String email;
	private String password;
	private long phoneNo;
	private String country;
	private String dob;
	private int age;
	private String appraisalStatus="Not approved";
	private float appraisalAmount;
	private String department;
	private double salary;
	private String skill;
	private String location;
	private int experince;
	private String adhaarNo;

}

