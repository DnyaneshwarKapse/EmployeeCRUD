package com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class Employee {

	@Id
	int id;
	String name;
	String post;
	LocalDate date;
	double salary;
	
	
	public Employee() {
		super();
		
	}
	
	public Employee(int id, String name, String post, LocalDate date, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.post = post;
		this.date = date;
		this.salary = salary;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", post=" + post + ", date=" + date + ", salary=" + salary
				+ "]";
	}
	
	
	

}