package com.datademo.DataDemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.datademo.DataDemo.AtharvaPerson;

@Repository
@Transactional

public class PersonJpaRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<AtharvaPerson> findAll(){
		TypedQuery<AtharvaPerson> namedQuery = entityManager.createNamedQuery("find_all_persons",AtharvaPerson.class);
		return namedQuery.getResultList();
		
	}
	public AtharvaPerson findById(int id){
		return entityManager.find(AtharvaPerson.class, id);
	}
	/*
	public AtharvaPerson update(AtharvaPerson person){
		return entityManager.merge(person);
	}
	public AtharvaPerson insert(AtharvaPerson person){
		//AtharvaPerson person = findById(person);
		return entityManager.merge(person);
	}
	*/
	
	public void deleteById(int id){
		AtharvaPerson person=findById(id);
		entityManager.remove(person);
	}
	
	
	
	
}
	

