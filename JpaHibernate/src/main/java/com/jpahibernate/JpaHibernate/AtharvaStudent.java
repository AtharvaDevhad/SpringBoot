 package com.jpahibernate.JpaHibernate;

import java.util.ArrayList;
import java.util.List;

//import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
*/
@Entity



public class AtharvaStudent {
	@Id
	@GeneratedValue
	
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Embedded
	private Address address;
	
	@OneToOne(fetch=FetchType.LAZY)
	private AtharvaPassport passport;
	
	@ManyToMany
//	(fetch=FetchType.EAGER)
	@JoinTable(name="AtharvaStudent_Course",
	joinColumns=@JoinColumn(name="Student_Id"),
	inverseJoinColumns =@JoinColumn(name="Course_Id"))
	private List<AtharvaCourse> courses=new ArrayList<>();
	
	
	
	protected AtharvaStudent() {
		
	}
	
	public AtharvaStudent(String name) {
		this.name=name;
	
	}
	public String getName() {
		return name;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public AtharvaPassport getPassport() {
		return passport;
	}

	public void setPassport(AtharvaPassport passport) {
		this.passport = passport;
	}
	
		public List<AtharvaCourse> getCourses() {
		return courses;
	}

	public void addCourse(AtharvaCourse course) {
		this.courses.add(course);
	}

	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "AtharvaStudent [name=" + name + "]";
	}
	

}
