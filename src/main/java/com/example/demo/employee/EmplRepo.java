package com.example.demo.employee;

import java.util.Date;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.EmployeeProjection1;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.QEmployee;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@CrossOrigin()
@Api(tags = "Employee Entity")
@RepositoryRestResource(collectionResourceRel="employees",path="employees",excerptProjection = EmployeeProjection1.class)
public interface EmplRepo extends JpaRepository<Employee, Integer>{

	@RestResource
	Page<Employee> findAll(Specification spec,Pageable pageable);
//	
	@RestResource(path = "byempid", rel = "byempid")
    Page<Employee> findAllByempid(@Param("empid") Integer empid,Pageable pageable);
	
//	@ApiOperation("find all employees who have this name")
	@RestResource(path = "byempname", rel = "byempame")
    Page<Employee> findAllByempnameContaining(@ApiParam(name = "empname", value = "name of the employee", type = "body") @Param("empname")  String empname,Pageable pageable);
	
	@RestResource(path = "byskill", rel = "byskill")
    Page<Employee> findByskillContaining(@Param("skill") String skill,Pageable pageable);
	
	@RestResource(path = "bydeptid", rel = "bydeptid")
	List<Employee> findBydeptid(@Param("deptid") Department deptid);//findAllBydeptDeptname 
	
	@RestResource(path = "bydesignation", rel = "bydesignation")
    Page<Employee> findAllBydesignationContaining(@Param("designation") String desigation,Pageable pageable);
	
	@RestResource(path = "bydoj", rel = "bydoj")
    List<Employee> findAllBydoj(@Param("doj")Date doj);
//	List<Employee> findAllByOrderBydojAsc();
//	List<Employee> findAllByOrderBydojDesc();
	
	
	
	@RestResource(path = "bysalary", rel = "bysalary")
    Page<Employee> findAllBysalary(@Param("salary") float salary,Pageable pageable);
//	//
	
	
	@RestResource(path = "bygrade", rel = "bygrade")
    Page<Employee> findAllBygrade(@Param("grade") Integer grade,Pageable pageable);
	
	
	@RestResource(path = "bycity", rel = "bycity")
    Page<Employee> findAllBycityContaining(@Param("city") String city,Pageable pageable);
	
	
	@RestResource(path = "bycountry", rel = "bycountry")
    Page<Employee> findAllBycountryContaining(@Param("country") String country,Pageable pageable);

	
	
	
	

	
	
	//testing delete by
//	@Transactional
//	@RestResource(path = "deletebyempname", rel = "deletebyempname")
//    List<Employee> deleteByempnameContaining(@Param("name") String empname);
	//
	
	
//	
}
