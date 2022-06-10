package com.sha.serverside.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.serverside.model.AthCourseStudent;

public interface AthCourseStudentRepository extends JpaRepository <AthCourseStudent,Long>{

	List<AthCourseStudent>findByAthCourseInstructorId(Long instructor);
	List<AthCourseStudent>findByAthStudentId(Long studentId);
}
