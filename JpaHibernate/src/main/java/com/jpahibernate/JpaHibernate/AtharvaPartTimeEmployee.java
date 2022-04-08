package com.jpahibernate.JpaHibernate;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class AtharvaPartTimeEmployee extends AtharvaEmployee {
	protected AtharvaPartTimeEmployee() {}
	
	public AtharvaPartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	
	}
	private BigDecimal hourlyWage;

}
