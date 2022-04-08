package com.jpahibernate.JpaHibernate;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = JpaHibernateApplication.class )
class StudentRepositoryTests {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;

	//private AtharvaStudent find;
//	@Test
//	//@Transactional
//	public void someTest() {
//		repository.someOperationToUnderstandPersistenceContext();
//	}


	
	
	
	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		AtharvaStudent student = em.find(AtharvaStudent.class,21L);
		System.out.println("student ->{}"+ student);
		System.out.println("passport ->{}"+ student.getPassport());
		
	
	
}
	
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		AtharvaPassport passport = em.find(AtharvaPassport.class,20L);
		System.out.println("passport ->{}"+ passport);
		System.out.println("student ->{}"+ passport.getStudent());
	}
	@Test
	@Transactional
	public void retrieveStudentAndCourse() {
		
		AtharvaStudent student= em.find(AtharvaStudent.class, 21L);
		System.out.println("student ->{}"+ student);
		System.out.println("courses ->{}"+ student.getCourses());
	
}
}
	/*
	@Test
	@DirtiesContext
	 public void deleteById_basic() {
		//AtharvaCourse course = repository.findById(1002L);
		repository.deleteById(1002L);
		assertNull(repository.findById(1002L));
		//assertEquals("Php",course.getName());

}
*/
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
	
	@Test
	@DirtiesContext
	 public void playWithEntityManager() {
		 repository.playWithEntityManager();
   }
  
}
*/
