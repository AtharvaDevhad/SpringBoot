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
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = JpaHibernateApplication.class )
public class NativeQueriesTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
      @Test
	 public void native_queries_basic() {
    	 Query query = em.createNativeQuery("Select * From atharva_course",AtharvaCourse.class);
		List<AtharvaCourse>  resultList = query.getResultList();
		//AtharvaCourse course = repository.findById(1001L);
		//assertEquals("Php",course.getName());
	    System.out.println("Select * From AtharvaCourse -> {}" + resultList);
      }
      @Test
 	 public void native_queries_with_parameter() {
     	 Query query = em.createNativeQuery("Select * From atharva_course where id = ?",AtharvaCourse.class);
     	 query.setParameter(1, 1001L);
 		List<AtharvaCourse>  resultList = query.getResultList();
 		//AtharvaCourse course = repository.findById(1001L);
 		//assertEquals("Php",course.getName());
 	    System.out.println("Select * From AtharvaCourse  where id = ? -> {}" + resultList);
       }
      @Test
  	 public void native_queries_with_named_parameter() {
      	 Query query = em.createNativeQuery("Select * From atharva_course where id = :id",AtharvaCourse.class);
      	 query.setParameter("id", 1001L);
  		List<AtharvaCourse>  resultList = query.getResultList();
  		//AtharvaCourse course = repository.findById(1001L);
  		//assertEquals("Php",course.getName());
  	    System.out.println("Select * From AtharvaCourse  where id = :id -> {}" + resultList);
        }
      @Test
      @Transactional
 	 public void native_queries_to_update() {
     	 Query query = em.createNativeQuery("Update atharva_course set last_updated_date=sysdate()",AtharvaCourse.class);
 		int noOfRowsUpdated = query.executeUpdate();
 		//AtharvaCourse course = repository.findById(1001L);
 		//assertEquals("Php",course.getName());
 	    System.out.println("noOfRowsUpdated -> {}" + noOfRowsUpdated);
       }
}
      /*
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
