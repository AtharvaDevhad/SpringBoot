package com.sha.serverside.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sha.serverside.model.AthCourse;
import com.sha.serverside.model.AthCourseStudent;
import com.sha.serverside.service.AthCourseStudentService;

@RestController
public class AthStudentContoller {
	
	@Autowired
	private AthCourseStudentService courseStudentService;	

	
	@GetMapping("/api/student/courses/{studentId}")
	public ResponseEntity<?> findAllCoursesOfStudent(@PathVariable Long studentId){
		List<AthCourse> courseList = 
				courseStudentService.findAllCoursesOfStudent(studentId).stream().map(cs-> cs.getCourse()).collect(Collectors.toList());
		return new ResponseEntity<>(courseList,HttpStatus.OK);
		
	}
	@PostMapping("/api/student/enroll")
	public ResponseEntity<?>enroll(@RequestBody AthCourseStudent CourseStudent){
		return new ResponseEntity<>(courseStudentService.saveCourseStudent(CourseStudent),HttpStatus.CREATED);
	}
	
}

