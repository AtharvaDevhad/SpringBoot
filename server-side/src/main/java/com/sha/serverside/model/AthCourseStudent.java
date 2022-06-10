package com.sha.serverside.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ath_course_student")
public class AthCourseStudent  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="student_id",referencedColumnName="id")
	private AthUser student;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="course_id",referencedColumnName="id")
	private AthCourse course;


	public AthCourseStudent(Long id, AthUser student, AthCourse course) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
	}


	public AthCourseStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
