package com.sha.serverside.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sha.serverside.model.AthUser;
import com.sha.serverside.service.AthCourseStudentService;

@RestController
public class AthTeacherController {

	
	@Autowired
	private AthCourseStudentService courseStudentService;
	
	@GetMapping("/api/teacher/student/{teacherId}")
	public ResponseEntity<?>findAllStudentsOfinstructor(@PathVariable Long teacherId ){
		List<AthUser> students = 
				courseStudentService.findAllStudentsOfInstructor(teacherId).stream().map(cs->cs.getStudent()).collect(Collectors.toList());
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
}
