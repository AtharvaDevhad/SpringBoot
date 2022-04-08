package com.jpahibernate.JpaHibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(classes = JpaHibernateApplication.class )
class JPQLTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
      @Test
	 public void jpql_basic() {
    	 Query Query = em.createNamedQuery("query_get_all_courses");
		List<AtharvaCourse>  resultList = Query.getResultList();
		//AtharvaCourse course = repository.findById(1001L);
		//assertEquals("Php",course.getName());
	    System.out.println("select c from AtharvaCourse c -> {}" + resultList);
      }
      @Test
 	 public void jpql_typed() {
     	 TypedQuery<AtharvaCourse> query = 
     			 em.createNamedQuery("query_get_all_courses",AtharvaCourse.class);
		List<AtharvaCourse>  resultList = query.getResultList();
     	System.out.println("select c from AtharvaCourse c -> {}" + resultList);
      }
      @Test
  	 public void jpql_where() {
      	 TypedQuery<AtharvaCourse> query = 
      			 em.createNamedQuery("query_get_100_step_courses",AtharvaCourse.class);
 		List<AtharvaCourse> resultList = query.getResultList();
      	System.out.println("select c from AtharvaCourse c where name like'% 100 steps '" + resultList);
       }
      @Test
   	 public void jpql_courses_without_students() {
       	 TypedQuery<AtharvaCourse> query = 
       			 em.createQuery("Select c from AtharvaCourse c where c.students is empty",AtharvaCourse.class);
  		List<AtharvaCourse> resultList = query.getResultList();
       	System.out.println("Results -> {}" + resultList);
        }
      @Test
    	 public void jpql_courses_with_atleast_2_students() {
        	 TypedQuery<AtharvaCourse> query = 
        			 em.createQuery("Select c from AtharvaCourse c where size (c.students) >= 2",AtharvaCourse.class);
   		List<AtharvaCourse> resultList = query.getResultList();
        	System.out.println("Results -> {}" + resultList);
         }
      @Test
 	 public void jpql_students_with_passport_in_a_certain_pattern() {
     	 TypedQuery<AtharvaStudent> query = 
   em.createQuery("Select s from AtharvaStudent s where s.passport.number like '%7891%'",AtharvaStudent.class);
		List<AtharvaStudent> resultList = query.getResultList();
     	System.out.println("Results -> {}" + resultList);
      }
      @Test
      public void join() {
    	  Query query =  em.createQuery("Select c,s from AtharvaCourse c JOIN c.students s");
    					List<Object[]> resultList = query.getResultList();
    			     	System.out.println("Results size -> {}" + resultList.size());
    			     	for(Object[] result:resultList) {
    			     		System.out.println("AtharvaCourse{} AtharvaStudent{}" + result[0] + result[1]);
    			     		
    		}
      }
    			     	
    			     	@Test
    			        public void left_join() {
    			      	  Query query =  em.createQuery("Select c,s from AtharvaCourse c LEFT JOIN c.students s");
    			      					List<Object[]> resultList = query.getResultList();
    			      			     	System.out.println("Results size -> {}" + resultList.size());
    			      			     	for(Object[] result:resultList) {
    			      			     		System.out.println("AtharvaCourse{} AtharvaStudent{}" + result[0] + result[1]);
    			      			     		
    			      		}
    			     	}
    			      			     	
    			      			     	@Test
    			      			      public void cross_join() {
    			      			    	  Query query =  em.createQuery("Select c,s from AtharvaCourse c,AtharvaStudent s");
    			      			    					List<Object[]> resultList = query.getResultList();
    			      			    			     	System.out.println("Results size -> {}" + resultList.size());
    			      			    			     	for(Object[] result:resultList) {
    			      			    			     		System.out.println("AtharvaCourse{} AtharvaStudent{}" + result[0] + result[1]);
    			      			    			     		
    			      			    		}
    			      			    			     	
    			      			       }
}
	//}
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
	*/
	//@Test
	//@DirtiesContext
	 //public void playWithEntityManager() {
		// repository.playWithEntityManager();
   //}
  
//}
