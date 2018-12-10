package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EmployeeProjection1;
import com.example.demo.advancedsearch.CriteriaParser;
import com.example.demo.advancedsearch.GenericSpecificationsBuilder;
import com.example.demo.model.Employee;
@CrossOrigin()
@EnableSpringDataWebSupport
@RestController

public class EmployeeController{

	@Autowired
    private EmplRepo emplrepo;
	

	@Autowired
	private ProjectionFactory factory;
	@Autowired
	private PagedResourcesAssembler<EmployeeProjection1> assembler;

	
    protected Specification<Employee> resolveSpecificationFromInfixExpr(String searchParameters) {
        CriteriaParser parser = new CriteriaParser();
        GenericSpecificationsBuilder<Employee> specBuilder = new GenericSpecificationsBuilder<>();
        return specBuilder.build(parser.parse(searchParameters), EmployeeSpecification::new);
    }
    
    @GetMapping(value = "/employees/search/byadvsearch",produces = "application/json")//remove "produces" key
    @ResponseBody
    public ResponseEntity<?> findAllByAdvPredicate(@RequestParam(value = "advsearch") String search,Pageable pageable){
        Specification<Employee> spec = resolveSpecificationFromInfixExpr(search);
        Page<Employee> emplo= emplrepo.findAll(spec, pageable);
        Page<EmployeeProjection1> projected = emplo.map(l -> factory.createProjection(EmployeeProjection1.class, l));
        PagedResources<Resource<EmployeeProjection1>> resources = assembler.toResource(projected);
        return ResponseEntity.ok(resources);
       
	}
    
    
}
