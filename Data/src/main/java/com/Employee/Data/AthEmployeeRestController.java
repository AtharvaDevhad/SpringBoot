package com.Employee.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.extern.slf4j.Slf4j;

public class AthEmployeeRestController {
	
	@RestController
	@RequestMapping("/api/tan")
	@CrossOrigin(origins ="http://localhost:4200/")
	//@Slf4j
	public class EmployeeRestcontroller {
		
		@Autowired
		EmployeeService employeeService;
		
		
//		@Autowired
//		EmployeeRepository employeeRepository;
		
		
//		@Min(value = 18, message = "Age must not be less than 18.")
//		@Max(value = 60, message = "Age must not be greater than 60.")
//		private Long age;
		
		@GetMapping("/message")
		public String DisplayMessage()
		{
			return "Hello Employee";
		}
		
		@GetMapping("/employee")
		public List<AthEmployee> FindAll()
		{
			return employeeService. findAll();
		}
												
		@PostMapping("/employee/add")
		public AthEmployee addEmployee(@RequestBody AthEmployee employee)
		{
		//	LocalDate birthD = employeeService.findByDob(dob);
			LocalDate curDate = LocalDate.now();
			   int age= Period.between(employee.getDob(), curDate).getYears();
			    if(age<=18) {
			    	throw new RuntimeException("You must at least 18 years old");
			    }
			   return employeeService.save(employee);
		}
	    @GetMapping("/employee/{id}")
		public Optional<AthEmployee> getbyid(@PathVariable Long id)
		{
	    	//custom exception handling
	    	if(id==2) {
	    		throw new RuntimeException("something went wrong!!");
	    	}
	    	return employeeService.findById(id);
	    	
		}
//	    public static int calculateAge(LocalDate dob)
//	    {
//	    LocalDate curDate = LocalDate.now();
	//   int age= Period.between(dob, curDate).getYears();
//	    if(age<=18) {
//	    	throw new RuntimeException("You must at least 18 years old");
//	    }
//	    return 0;
//	    }
	    @PutMapping("/employee/update-employee")
	    public AthEmployee updatedetails(@RequestBody AthEmployee athemployee)
	    {
//	    	LocalDate date = LocalDate.parse(dB, today);
//	        Date dateNow = new Date();
//	        LocalDate date1 = LocalDate.parse(dateNow.toString(),today);
//	        int days = Days.daysBetween(date,date1).getDays();
//	         // Period age= Period.between(dB, today);
			   
	    	AthEmployee emp = employeeService.getById(athemployee.getId());
	    	emp.setId(athemployee.getId());
	    	emp.setName(athemployee.getName());
	    	emp.setDob(athemployee.getDob());
	    	
	    	emp.setSalary(athemployee.getSalary());
	    	emp.setCity(athemployee.getCity());
	    	LocalDate curDate = LocalDate.now();
			   int age= Period.between(athemployee.getDob(), curDate).getYears();
			    if(age<=18) {
			    	throw new RuntimeException("You must at least 18 years old");
			    }
	    	return employeeService.save(emp); 	
	    }
	    @DeleteMapping("/employee/delete-employee/{id}")
	    public String deleteEmployeebyid(@PathVariable Long id)
	    {
	    	//employeeRepository.deleteEmployeeById(id);
	    	AthEmployee em = employeeService.getById(id);
	    	employeeService.delete(em);
	    	//log.info("Record deleted of employee whose Id was: "+id);
	    	return "A record Deleted!";
	    	                                  
	    }
//	    @ExceptionHandler()
//	    @ResponseStatus(HttpStatus.NOT_FOUND)
//	    public ResponseEntity<String> handleNoSuchElementFoundException(
//	          NoSuchElementFoundException exception){
//	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
//	    }
	}

}
