package com.sha.serverside.service;

import java.util.List;

import com.sha.serverside.model.AthCourse;

public interface AthCourseService {

	AthCourse addCourse(AthCourse course);

	AthCourse updateCourse(AthCourse course);


	void deleteCourse(Long courseId);

	List<AthCourse> findAllCourses();

}
