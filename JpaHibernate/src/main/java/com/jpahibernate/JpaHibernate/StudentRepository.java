package com.jpahibernate.JpaHibernate;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	public AtharvaStudent findById(Long id) {
		return em.find(AtharvaStudent.class, id);
	}
	
	public AtharvaStudent save(AtharvaStudent student){
		if(student.getId()==null){
			em.persist(student);
		
	} else {
		em.merge(student);	
	}	
		return student;
	}

	public void saveStudentWithPassport() {
		// TODO Auto-generated method stub
		
	}

	
	/*
	public void deleteById(Long id) {
		AtharvaStudent student = findById(id);
		em.remove(student);

	}
	*/
//	public void saveStudentWithPassport() {
//		AtharvaPassport passport = new AtharvaPassport("A12345");
//		em.persist(passport);
////		
//     AtharvaStudent student = new AtharvaStudent("Atharva");
//     student.setPassport(passport);
//     em.persist(student);
//     // AtharvaStudent student2 = new AtharvaStudent(" Angular JS in 100 Steps");
    // em.persist(student2);
     
     
   //  em.flush();
     
    
     //em.detach(student1);
     //em.detach(student2);
    //tudent1.setName("Web Services in 100 Steps -updated");
    //m.persist(student);
  // AtharvaStudent student2 = findById(1001L);
     //udent2.setName("Php 100 updated");
     //student1.setName(null);
    // student2.setName("Angular JS in 100 Steps - updated");
    // em.refresh(student1);
     
     //em.flush();

//	public void someOperationToUnderstandPersistenceContext() {
//		AtharvaStudent student = em.find(AtharvaStudent.class,21L);
//		AtharvaPassport passport = student.getPassport();
//		passport.setNumber("E123456");
//		student.setName("sneha");
//	}
	public void insertAtharvaCourseAndAtharvaStudent(AtharvaStudent student,AtharvaCourse course) {
		//AtharvaStudent student = new AtharvaStudent("Prasad");
		//AtharvaCourse course = new AtharvaCourse("Microservices in 100 steps");
	    student.addCourse(course);
		course.addStudent(student);
		em.persist(student);
		em.persist(course);
		//em.persist(student);
	}
}

