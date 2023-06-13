package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Dao;
import com.entity.Employee;

@Service
public class EmpServive {

	@Autowired
	Dao d;
	
	public List<Employee> getAll() {
		return d.getAll();
	}
	
	public String addInfo(Employee e) {
		return d.addInfo(e);
	}
	
	public String updateData(Employee e) {
		return d.updateData(e);
	}
	
	public String deleteData(int id) {
		return d.deleteData(id);
	}

	public Employee getbyId(int id) {
		return d.getbyId(id);
	}

	public Employee getSecMaxSal() {
		return d.getSecMaxSal();
	}

	public List<Employee> getSameName(String name) {
		return d.getSameName(name);
		
	}
}
