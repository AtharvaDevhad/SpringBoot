package com.jpahibernate.JpaHibernate;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public class EmployeeRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public void insert(AtharvaEmployee employee) {
		em.persist(employee);
	}
	
	public List<AtharvaPartTimeEmployee>retrieveAllPartTimeEmployees(){
		return em.createQuery("select e from AtharvaPartTimeEmployee e",AtharvaPartTimeEmployee.class).
				getResultList();
	}
	public List<AtharvaFullTimeEmployee>retrieveAllFullTimeEmployees(){
		return em.createQuery("select e from AtharvaFullTimeEmployee e",AtharvaFullTimeEmployee.class).
				getResultList();
	}
	
	public AtharvaCourse findById(Long id) {
		return em.find(AtharvaCourse.class, id);
	}
}	