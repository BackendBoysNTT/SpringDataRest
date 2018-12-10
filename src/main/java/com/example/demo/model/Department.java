package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="department")

@JsonPropertyOrder({ "deptid", "deptname","depthead" })
public class Department implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_seq_gene")
	@SequenceGenerator(name="my_seq_gene", sequenceName="depid_seq",allocationSize=1)
	private int deptid;
	
	@Column(unique=true)
	private String deptname;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="deptheadid",nullable=true)
	private Employee depthead;
	

	
	
	

	public Employee getDepthead() {
		return depthead;
	}
	public void setDepthead(Employee depthead) {
		this.depthead = depthead;
	}

	
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	
	
	
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	
	

	
	
}
