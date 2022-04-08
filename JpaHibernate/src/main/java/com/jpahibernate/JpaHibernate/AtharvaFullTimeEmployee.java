package com.jpahibernate.JpaHibernate;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class AtharvaFullTimeEmployee extends AtharvaEmployee {
	protected AtharvaFullTimeEmployee() {}
	
	public AtharvaFullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	
	}
	private BigDecimal salary;

}
