 package com.jpahibernate.JpaHibernate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@MappedSuperclass
//@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="Employee_Type")
public  abstract class AtharvaEmployee {
	@Id
	@GeneratedValue
	
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	protected AtharvaEmployee() {
		
	}
	
	public AtharvaEmployee(String name) {
		this.name=name;
	
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "AtharvaEmployee [name=" + name + "]";
	}
	

}
