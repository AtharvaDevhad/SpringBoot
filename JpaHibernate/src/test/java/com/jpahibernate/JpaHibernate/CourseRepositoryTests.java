package com.jpahibernate.JpaHibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = JpaHibernateApplication.class )
class CourseRepositoryTests {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;
	
	
	@Test
	public void findById_basic() {
		AtharvaCourse course = repository.findById(1346L);
		assertEquals("Java in 100 steps",course.getName());
	}
		//System.out.println("Testing is Running");
	
	@Test
	//@Transactional
	 public void findById_firstLevelCacheDemo() {
		AtharvaCourse course = repository.findById(1001L);
		System.out.println("First Course Retrieved {}" + course);
		AtharvaCourse course1 = repository.findById(1001L);
		System.out.println("First Course Retrieved again {}" + course1);
		assertEquals("Php 100 updated",course.getName());
		assertEquals("Php 100 updated",course1.getName());
	}
	//}
	
	@Test
	@DirtiesContext
	 public void deleteById_basic() {
		//AtharvaCourse course = repository.findById(1002L);
		repository.deleteById(1003L);
		assertNull(repository.findById(1003L));
		//assertEquals("Php",course.getName());

}

	/*
	@Test
	@DirtiesContext
	 public void save_basic() {
		AtharvaCourse course = repository.findById(1001L);
		assertEquals("Php100 - updated",course.getName());
		course.setName("Php100");
		repository.save(course);
		
		AtharvaCourse course1 = repository.findById(1003L);
		assertEquals("CSS" ,course1.getName());
		course1.setName("CSS - updated");
		repository.save(course1);
		
		//assertNull(repository.findById(1003L));
		//assertEquals("Php",course.getName());
	}
	*/
	@Test
	@DirtiesContext
	 public void playWithEntityManager() {
		 repository.playWithEntityManager();
	}
   
	//@Test
	//@Transactional
	//@DirtiesContext
//	 public void retrieveCourseForReview() {
		//AtharvaReview review = em.find(AtharvaReview.class,123L);
		//System.out.println("{}" + review.getCourse());
  // }
	/*
	@Test
	@Transactional(isolation=Isolation.REPEATABLE_READ)
	@DirtiesContext
     public void retrieveCourseForReview() {
		AtharvaReview review = em.find(AtharvaReview.class,123L);
		System.out.println("{}" + review.getCourse());
  
}
*/
}
