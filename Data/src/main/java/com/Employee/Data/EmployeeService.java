package com.Employee.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class EmployeeService {
	
	@Autowired
	employeeRepository employeeRepository;
	public List<AthEmployee> FindAll() {
		return employeeRepository.findAll();
	}
	public AthEmployee save(AthEmployee employee) {
		return employeeRepository.save(employee);
	}
	public Optional<AthEmployee> findById(Long id) {
		return employeeRepository.findById(id);
	}
	public AthEmployee getById(Long id) {
		return employeeRepository.getById(id);
	}
	public void deleteEmployeeById(Long id) {
		 employeeRepository.deleteById(id);
	}
	public LocalDate findByDob(LocalDate dB) {
    AthEmployee AthEmployee = new AthEmployee();
	return AthEmployee.getDob();
		
	}
	
//	public long getAge(Calendar dob) throws Exception {
//        Calendar today = Calendar.getInstance();
//
//        int curYear = today.get(Calendar.YEAR);
//        int dobYear = dob.get(Calendar.YEAR);
//
//        int age = curYear - dobYear;
//        return age;
//        }
	public void delete(AthEmployee em) {
		// TODO Auto-generated method stub
		employeeRepository.delete(em);
	}
	public List<AthEmployee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

