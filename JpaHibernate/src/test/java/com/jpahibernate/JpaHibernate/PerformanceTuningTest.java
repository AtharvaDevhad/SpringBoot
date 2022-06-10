package com.jpahibernate.JpaHibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = JpaHibernateApplication.class )
class PerformanceTuningTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@Autowired
	EntityManager em;
	
	
	@Test
	@Transactional
	public void creatingNPlusOneProblem() {
		List<AtharvaCourse> courses = em
				.createNamedQuery("query_get_all_courses",AtharvaCourse.class)
				.getResultList();
		for(AtharvaCourse course:courses) {
			System.out.println("AtharvaCourse -> {} AtharvaStudent-> {}" + course  + course.getStudents());
		}
		
	}
	@Test
	@Transactional
	public void solvingNPlusOneProblem_Entitygraph() {
		
		EntityGraph<AtharvaCourse> entityGraph = em.createEntityGraph(AtharvaCourse.class);
		Subgraph<Object> subGraph = entityGraph.addSubgraph("students");
		
		List<AtharvaCourse> courses = em
				.createNamedQuery("query_get_all_courses",AtharvaCourse.class)
				.setHint("javax.persistence.loadgraph",entityGraph )
				.getResultList();
		
		for(AtharvaCourse course:courses) {
			System.out.println("AtharvaCourse -> {} AtharvaStudent-> {}" + course  + course.getStudents());
		}
		
	}
	@Test
	@Transactional
	public void solvingNPlusOneProblem_JoinFetch() {
		List<AtharvaCourse> courses = em
				.createNamedQuery("query_get_all_courses",AtharvaCourse.class)
				.getResultList();
		for(AtharvaCourse course:courses) {
			System.out.println("AtharvaCourse -> {} AtharvaStudent-> {}" + course  + course.getStudents());
		}
		
	}
}		