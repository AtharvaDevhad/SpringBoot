package com.jpahibernate.JpaHibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	//private AtharvaCourse findById;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;


	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
//		List<AtharvaReview> reviews=new ArrayList<>();
//		 reviews.add (new AtharvaReview("5","Great Hands-on Stuff."));	
//		 reviews.add (new AtharvaReview("5","Hatsoff."));
//		
		//courseRepository.addHardcodedReviewsForCourse();
		//courseRepository.addReviewsForCourse(1346L,reviews);
		// studentRepository.saveStudentWithPassport();
		 //repository.playWithEntityManager();
		
		//AtharvaCourse course = repository.findById(1001L);
		
		/*
		 * logger.info("AtharvaCourse1001->{}",course);
		 
		System.out.println("AtharvaCourse1001->{}" + course);
		*/
		//repository.save(new AtharvaCourse("Java in 100 steps"));
		
		//repository.deleteById(1001L);;
		//studentRepository.insertHardCodedAtharvaCourseAndAtharvaStudent();
		//studentRepository.insertAtharvaCourseAndAtharvaStudent(new AtharvaStudent("prasad"),new AtharvaCourse("Microservices in 100 steps"));
		/*
		employeeRepository.insert (
				new AtharvaPartTimeEmployee("Rushi",new BigDecimal("50")));
		employeeRepository.insert (
				new AtharvaFullTimeEmployee("Kunal",new BigDecimal("10000")));
		
		System.out.println("All AtharvaFullTimeEmployees -> {}"+ 
		employeeRepository.retrieveAllFullTimeEmployees());
		System.out.println("All AtharvaPartTimeEmployees -> {}"+
		employeeRepository.retrieveAllPartTimeEmployees());
		*/
	}
	

}

