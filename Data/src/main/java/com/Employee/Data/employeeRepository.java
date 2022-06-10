package com.Employee.Data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<AthEmployee, Long> {

}
