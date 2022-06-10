package com.Employee.Data;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="ath_employee")
@Data
public class AthEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
    private String name;
	
	
	@Column(name="dob")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	//@Min(value = 18, message = "Age must not be less than 18.")
//public class AthEmployee {
//
//
	private LocalDate dob;
	@Column(name="salary")
	private Long salary;
	
	
	@Column(name="city")
	private String city;


	public AthEmployee(Long id, String name, LocalDate dob, Long salary, String city) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.city = city;
	}


	public AthEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
