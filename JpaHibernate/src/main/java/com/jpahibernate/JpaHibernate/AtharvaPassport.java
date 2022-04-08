 package com.jpahibernate.JpaHibernate;

//import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
*/
import javax.persistence.OneToOne;

@Entity



public class AtharvaPassport {
	@Id
	@GeneratedValue
	
	private Long id;
	
	@Column(nullable = false)
	private String number;
	
	
	@OneToOne(fetch=FetchType.LAZY ,mappedBy= "passport")
	private AtharvaStudent student;
	
	
	

	protected AtharvaPassport() {
		
	}
	
	public AtharvaPassport(String number) {
		this.number=number;
	
	}
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public AtharvaStudent getStudent() {
		return student;
	}

	public void setStudent(AtharvaStudent student) {
		this.student = student;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "AtharvaPassport [number =" +number+ "]";
	}
	

}
