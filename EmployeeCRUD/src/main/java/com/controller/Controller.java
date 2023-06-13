package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.service.EmpServive;

@RestController
public class Controller {

	@Autowired
	EmpServive es;
	
	@GetMapping("getAllRecord")
	public List<Employee> getData() {
		return es.getAll();
	}
	
	@PostMapping("postRecord")
	public String addInfo(@RequestBody Employee e) {
		return es.addInfo(e);
	}
	
	@PutMapping("updateRecord")
	public String updateData(@RequestBody  Employee e) {
		return es.updateData(e);
	}
	
	@DeleteMapping("deleteRecord")
	public String deleteData(@RequestBody int id) {
		return es.deleteData(id);
	}
	
	@GetMapping("getbyIdRecord/{id}")
	public Employee getbyId(@PathVariable int id) {
		return es.getbyId(id);
	}
	@GetMapping("getSecMaxSalRecord")
	public Employee getSecMaxSal() {
		return es.getSecMaxSal();
	}
	
	@GetMapping("GetSameNameEmployee/{name}")
	public List<Employee> getSameName(@PathVariable String name) {
		return es.getSameName(name);
	}
}
