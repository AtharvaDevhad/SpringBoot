package com.jpahibernate.JpaHibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = JpaHibernateApplication.class )
class CourseSpringDataRepositoryTests {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSpringDataRepository repository;
	
	@Test
	 public void findById_CoursePresent() {
		Optional<AtharvaCourse> courseOptional = repository.findById(1001L);
		assertTrue(courseOptional.isPresent() );
	}
	@Test
	 public void findById_CourseNotPresent() {
		Optional<AtharvaCourse> courseOptional = repository.findById(5001L);
		assertFalse(courseOptional.isPresent() );
	}
	@Test
	 public void playingAroundWithSpringDataRepository() {
		//AtharvaCourse course=new AtharvaCourse("Microservices in 100 Steps");
		//repository.save(course);
		
		//course.setName("Microservices in 100 Steps -updated");
		//repository.save(course);
		System.out.println("Courses->{}" + repository.findAll());
		System.out.println("Count->{}" + repository.count());
			
	}
	@Test
	 public void sort() {
		Sort sort = Sort.by(Sort.Direction.ASC,"name");
		System.out.println("SortedCourses->{}" + repository.findAll(sort));
		System.out.println("Count->{}" + repository.count());
			
	}
	@Test
	 public void pagination() {
	 PageRequest pageRequest = PageRequest.of(0, 3);
	 Page<AtharvaCourse> firstpage = repository.findAll(pageRequest);
	System.out.println("FirstPage -> {}" + firstpage.getContent());
	       Pageable secondPageable = firstpage.nextPageable();
	       Page<AtharvaCourse>secondPage = repository.findAll(secondPageable);
	       System.out.println("SecondPage -> {}" + secondPage.getContent());
	}
	@Test
	 public void findUsingName() {
		System.out.println("FindByName->{}" + repository.findByName("Angular JS in 100 Steps"));
		
			
	}
	
	
}
