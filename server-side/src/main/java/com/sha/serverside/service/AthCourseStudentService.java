package com.sha.serverside.service;

import java.util.List;

import com.sha.serverside.model.AthCourseStudent;

public interface AthCourseStudentService {

	AthCourseStudent saveCourseStudent(AthCourseStudent courseStudent);

	List<AthCourseStudent> findAllCoursesOfStudent(Long studentId);

	List<AthCourseStudent> findAllStudentsOfInstructor(Long InstructorId);

	List<AthCourseStudent> findAllEnrollments();

}
