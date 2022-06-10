package com.datademo.DataDemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.datademo.DataDemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("User id 102->{}" + repository.findById(102));
		
		//System.out.println("inserting ->104 {}" + repository.insert(new AtharvaPerson(104,"Sumedh","Nanded",new Date())));
		//System.out.println("Updating into Atharva_person -> {} " + repository.update(new AtharvaPerson(103, "Devansh", "Bavdhan", new Date())));
		//repository.deleteById(860);
		
		System.out.println("All users->{}" + repository.findAll());
		//System.out.println("Deleting 103-> No Of Rows Deleted-{}" +dao.deleteById(103));
		//
		//System.out.println("updating 103-> {}" +dao.update(new AtharvaPerson(103,"Kunal","KarveNagar", new Date())));
		//
	}

}
