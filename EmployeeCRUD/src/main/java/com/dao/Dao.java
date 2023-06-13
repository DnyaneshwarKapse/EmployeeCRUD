package com.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Employee;


@Repository

public class Dao {
	
	@Autowired
	SessionFactory sf;
	
	public List<Employee> getAll() {
		Session sn = sf.openSession();
		Criteria cr = sn.createCriteria(Employee.class);
		List<Employee> li = cr.list();
		sn.close();
		return li;
		
	}

	public String addInfo(Employee e) {
		Session sn = sf.openSession();
		Criteria cr = sn.createCriteria(Employee.class);
		Transaction tr = sn.beginTransaction();
		sn.save(e);
		tr.commit();
		sn.close();
		return "Save Data...";
		
	}

	public String updateData(Employee e) {
		Session sn = sf.openSession();
		Criteria cr = sn.createCriteria(Employee.class);
		Transaction tr = sn.beginTransaction();
		sn.update(e);
		tr.commit();
		sn.close();
		return "Data Updating...";
		
	}

	public String deleteData(int no) {
		Session sn = sf.openSession();
		Criteria cr = sn.createCriteria(Employee.class);
		Transaction tr = sn.beginTransaction();
		Employee em = sn.load(Employee.class, no);
		sn.delete(em);
		tr.commit();
		sn.close();
		return "Data Deleting...";
	}

	public Employee getbyId(int id) {
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		Employee em = sn.get(Employee.class, id);
		tr.commit();
		sn.close();
		return em;
		
	}

	public Employee getSecMaxSal() {
		Session sn = sf.openSession();
		Criteria cr = sn.createCriteria(Employee.class);
		Query query = sn.createNativeQuery("SELECT * FROM Employee WHERE salary = (SELECT DISTINCT salary FROM Employee ORDER BY salary DESC LIMIT 1, 1)", Employee.class);
		Employee shs = (Employee) query.uniqueResult();
		sn.close();
		return shs;
	}

	public List<Employee> getSameName(String name) {
		Session sn = sf.openSession();
		String hql = "SELECT e FROM Employee e WHERE e.name = :employeeName";
		Query query = sn.createQuery(hql);
		query.setParameter("employeeName", name);
		List<Employee> employees = query.list();
		return employees;
		
	}
	
}

