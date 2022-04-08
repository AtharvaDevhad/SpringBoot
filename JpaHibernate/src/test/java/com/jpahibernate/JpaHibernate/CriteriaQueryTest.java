package com.jpahibernate.JpaHibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(classes = JpaHibernateApplication.class )
class CriteriaQueryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
      @Test
	 public void all_courses() {
    	CriteriaBuilder cb = em.getCriteriaBuilder(); 
    	CriteriaQuery<AtharvaCourse> cq = cb.createQuery(AtharvaCourse.class);
    	
    	Root<AtharvaCourse> courseRoot = cq.from( AtharvaCourse.class);
    	  
    	 TypedQuery<AtharvaCourse> Query = em.createQuery(cq.select(courseRoot));
		List<AtharvaCourse>  resultList = Query.getResultList();
	    System.out.println("select c from AtharvaCourse c -> {}" + resultList);
      }
      @Test
 	 public void all_courses_having_100_Steps() {
     	CriteriaBuilder cb = em.getCriteriaBuilder(); 
     	CriteriaQuery<AtharvaCourse> cq = cb.createQuery(AtharvaCourse.class);
     	
     	Root<AtharvaCourse> courseRoot = cq.from( AtharvaCourse.class);
     	Predicate like100Steps = cb.like(courseRoot.get("name"), "%100 Steps");
     	cq.where(like100Steps);
     	  
     	 TypedQuery<AtharvaCourse> Query = em.createQuery(cq.select(courseRoot));
 		List<AtharvaCourse>  resultList = Query.getResultList();
 	    System.out.println("select c from AtharvaCourse c -> {}" + resultList);
       }
      @Test
  	 public void all_courses_without_students() {
      	CriteriaBuilder cb = em.getCriteriaBuilder(); 
      	CriteriaQuery<AtharvaCourse> cq = cb.createQuery(AtharvaCourse.class);
      	
      	Root<AtharvaCourse> courseRoot = cq.from( AtharvaCourse.class);
      	Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
      	cq.where(studentsIsEmpty);
      	  
      	 TypedQuery<AtharvaCourse> Query = em.createQuery(cq.select(courseRoot));
  		List<AtharvaCourse>  resultList = Query.getResultList();
  	    System.out.println("select c from AtharvaCourse c -> {}" + resultList);
        }
      @Test
   	 public void join() {
       	CriteriaBuilder cb = em.getCriteriaBuilder(); 
       	CriteriaQuery<AtharvaCourse> cq = cb.createQuery(AtharvaCourse.class);
       	
       	Root<AtharvaCourse> courseRoot = cq.from( AtharvaCourse.class);
       	Join<Object, Object> join = courseRoot.join("students");
       	  
       	 TypedQuery<AtharvaCourse> Query = em.createQuery(cq.select(courseRoot));
   		List<AtharvaCourse>  resultList = Query.getResultList();
   	    System.out.println("select c from AtharvaCourse c -> {}" + resultList);
         }
      @Test
    	 public void left_join() {
        	CriteriaBuilder cb = em.getCriteriaBuilder(); 
        	CriteriaQuery<AtharvaCourse> cq = cb.createQuery(AtharvaCourse.class);
        	
        	Root<AtharvaCourse> courseRoot = cq.from( AtharvaCourse.class);
        	Join<Object, Object> join = courseRoot.join("students",JoinType.LEFT);
        	  
        	 TypedQuery<AtharvaCourse> Query = em.createQuery(cq.select(courseRoot));
    		List<AtharvaCourse>  resultList = Query.getResultList();
    	    System.out.println("select c from AtharvaCourse c -> {}" + resultList);
          }
}
      