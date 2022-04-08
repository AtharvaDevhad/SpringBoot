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
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	public AtharvaCourse findById(Long id) {
		return em.find(AtharvaCourse.class, id);
	}
	
	public AtharvaCourse save(AtharvaCourse course){
		if(course.getId()==null){
			em.persist(course);
		
	} else {
		em.merge(course);	
	}	
		return course;
	}
	
	/*
	public void deleteById(Long id) {
		AtharvaCourse course = findById(id);
		em.remove(course);

	}
	*/
	public void playWithEntityManager() {
		
     AtharvaCourse course1 = new AtharvaCourse("Web Services in 100 Steps");
    // em.persist(course1);
     // AtharvaCourse course2 = new AtharvaCourse(" Angular JS in 100 Steps");
    // em.persist(course2);
     
     
   //  em.flush();
     
    
     //em.detach(course1);
     //em.detach(course2);
     course1.setName("Web Services in 100 Steps -updated");
     em.persist(course1);
     AtharvaCourse course2 = findById(1001L);
     course2.setName("Php 100 updated");
     //course1.setName(null);
    // course2.setName("Angular JS in 100 Steps - updated");
    // em.refresh(course1);
     
     //em.flush();
	}

	public void addHardcodedReviewsForCourse() {
		AtharvaCourse course = findById(1346L);
		System.out.println("course.getReviews()->{}" + course.getReviews());
		AtharvaReview review1=new AtharvaReview("5","Great Hands-on Stuff.");	
		AtharvaReview review2=new AtharvaReview("5","Hatsoff.");
		
		course.addReview(review1);
		review1.setCourse(course);
		
		course.addReview(review2);
		review2.setCourse(course);
		
		em.persist(review1);
		em.persist(review2);
		
		
		// TODO Auto-generated method stub
		
	}
	public void addReviewsForCourse(Long courseId,List<AtharvaReview> reviews) {
		AtharvaCourse course = findById(courseId);
		//System.out.println("course.getReviews()->{}" + course.getReviews());
		//AtharvaReview review1=new AtharvaReview("5","Great Hands-on Stuff.");	
		//AtharvaReview review2=new AtharvaReview("5","Hatsoff.");
		for(AtharvaReview review:reviews)
		{
		course.addReview(review);
		review.setCourse(course);
		
		//course.addReview(review2);
		//review2.setCourse(course);
		
		//em.persist(review);
		//em.persist(review2);
		
		}	
		
		
	}
	
}
