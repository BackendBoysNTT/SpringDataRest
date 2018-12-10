package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmployee is a Querydsl query type for Employee
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmployee extends EntityPathBase<Employee> {

    private static final long serialVersionUID = 1829973485L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmployee employee = new QEmployee("employee");

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final QDepartment deptid;

    public final StringPath designation = createString("designation");

    public final DatePath<java.util.Date> doj = createDate("doj", java.util.Date.class);

    public final NumberPath<Integer> empid = createNumber("empid", Integer.class);

    public final StringPath empname = createString("empname");

    public final NumberPath<Integer> grade = createNumber("grade", Integer.class);

    public final NumberPath<Float> salary = createNumber("salary", Float.class);

    public final StringPath skill = createString("skill");

    public QEmployee(String variable) {
        this(Employee.class, forVariable(variable), INITS);
    }

    public QEmployee(Path<? extends Employee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmployee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEmployee(PathMetadata metadata, PathInits inits) {
        this(Employee.class, metadata, inits);
    }

    public QEmployee(Class<? extends Employee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.deptid = inits.isInitialized("deptid") ? new QDepartment(forProperty("deptid"), inits.get("deptid")) : null;
    }

}

