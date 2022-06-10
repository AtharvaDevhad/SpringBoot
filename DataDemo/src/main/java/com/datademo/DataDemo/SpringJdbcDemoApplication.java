//package com.datademo.DataDemo;
//
//import java.util.Date;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
////@SpringBootApplication
//public class SpringJdbcDemoApplication implements CommandLineRunner {
//	
//	
//	private Logger logger=LoggerFactory.getLogger(this.getClass());
//	
//	@Autowired
//	PersonJdbcDAO dao;
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringJdbcDemoApplication.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		
//		System.out.println("All users->{}" +dao.findAll());
//		
//		System.out.println("User id 102->{}" +dao.findById(102));
//		
//		//System.out.println("Deleting 103-> No Of Rows Deleted-{}" +dao.deleteById(103));
//		
//		//System.out.println("inserting 104-> {}" +dao.insert(new AtharvaPerson(104,"Sumedh","Nanded",new Date())));
//		
//		//System.out.println("updating 103-> {}" +dao.update(new AtharvaPerson(103,"Kunal","KarveNagar", new Date())));
//		System.out.println("Updating into Atharva_person -> {} "
//				+dao.update(new AtharvaPerson(103, "Devansh", "Bavdhan", new Date())));
//		
//	}
//
//}
