package com.sha.serverside.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sha.serverside.model.AthCourse;
import com.sha.serverside.repository.AthCourseRepository;

@Service
@Transactional
public class AthCourseServiceImpl implements AthCourseService {
	
	@Autowired
	private AthCourseRepository courseRepository;
	
	@Override
	public AthCourse addCourse(AthCourse course) {
	return courseRepository.save(course);
	}
	@Override
	public AthCourse updateCourse(AthCourse course) {
		return courseRepository.save(course);
	}
	@Override
	public void deleteCourse(Long courseId) {
		courseRepository.deleteById(courseId);
	}
	@Override
	public List<AthCourse> findAllCourses(){
		return courseRepository.findAll();
	}
	
}
