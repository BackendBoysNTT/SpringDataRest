package com.example.demo;


import java.util.Date;


import org.springframework.data.rest.core.config.Projection;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Projection(name = "inlineRecords3", types = { Employee.class }) //FOR EMPLOYEE
public interface EmployeeProjection2 {
	int getEmpid();
	String getEmpname();
	String getSkill();
	float getSalary();
	int getGrade();
	String getCity();
	String getCountry();
	Date getDoj();
	String getDesignation();
}