package com.sha.serverside.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sha.serverside.model.AthCourseStudent;
import com.sha.serverside.model.AthRole;
import com.sha.serverside.model.AthUser;
import com.sha.serverside.service.AthCourseService;
import com.sha.serverside.service.AthCourseStudentService;
import com.sha.serverside.service.AthUserService;

@RestController
public class AthUserController {
	
	@Autowired
	private AthUserService userService;
	
	@Autowired
	private AthCourseService courseService;
	
	@Autowired
	private AthCourseStudentService courseStudentService;
	
	@PostMapping("/api/user/registration")
	public ResponseEntity<?> register(@RequestBody AthUser user){
	if(userService.findByAthUsername (user.getUsername())!=null) {
	return new ResponseEntity<>	(HttpStatus.CONFLICT);
	}
	user.setRole(AthRole.STUDENT);
	return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
}
	
	@GetMapping("/api/user/login")
	public ResponseEntity<?>getUser(Principal principal){
		if(principal == null) {
		return ResponseEntity.ok(principal);
		}
		return new ResponseEntity<>(userService.findByAthUsername(principal.getName()),HttpStatus.OK);
		}
	@PostMapping("/api/user/enroll")
	public ResponseEntity<?>enrollCourse(@RequestBody AthCourseStudent courseStudent){
		return new ResponseEntity<>(courseStudentService.saveCourseStudent(courseStudent),HttpStatus.CREATED);
	}
	@GetMapping("/api/user/courses")
	public ResponseEntity<?>getAllCourses(){
		return  ResponseEntity.ok(courseService.findAllCourses());
	}
}
