package com.sha.serverside.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sha.serverside.model.AthCourseStudent;
import com.sha.serverside.repository.AthCourseStudentRepository;

@Service
@Transactional
public class AthCourseStudentServiceImpl implements AthCourseStudentService{

	@Autowired
	private AthCourseStudentRepository courseStudentRepository;
	
	@Override
	public AthCourseStudent saveCourseStudent(AthCourseStudent courseStudent) {
		return courseStudentRepository.save((courseStudent));
	}
	@Override
	public List<AthCourseStudent>findAllCoursesOfStudent(Long studentId){
		return courseStudentRepository.findByAthStudentId(studentId);
	}
	
	@Override
	public List<AthCourseStudent>findAllStudentsOfInstructor(Long InstructorId){
		return courseStudentRepository.findByAthCourseInstructorId(InstructorId);
	}
	@Override
	public List<AthCourseStudent>findAllEnrollments(){
		return courseStudentRepository.findAll();
	}
	
}
