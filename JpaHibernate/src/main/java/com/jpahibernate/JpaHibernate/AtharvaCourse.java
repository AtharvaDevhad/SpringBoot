 package com.jpahibernate.JpaHibernate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "query_get_all_courses",
		        query = "select c from AtharvaCourse c"),
		@NamedQuery(name = "query_get_all_courses_join_fetch",
		query = "select c from AtharvaCourse c JOIN FETCH c.students s"),
		@NamedQuery(name = "query_get_100_step_courses",
		query = "select c from AtharvaCourse c where name like '%100 Steps'")

		}
		)
@Cacheable
@SQLDelete(sql="update atharva_course set is_deleted=true where id=?")
@Where(clause="is_deleted = false")


public class AtharvaCourse {
	private static Logger lOGGER= LoggerFactory.getLogger(AtharvaCourse.class);
	@Id
	@GeneratedValue
	
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	
	@OneToMany(mappedBy="course",fetch=FetchType.EAGER)
	private List<AtharvaReview> reviews=new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	@JsonIgnore
	private List<AtharvaStudent> students=new ArrayList<>();
	
	
	@UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
	@CreationTimestamp
    private LocalDateTime createdDate;
	
	private boolean isDeleted;
	
	@PreRemove 
	private void preRemove() {
		System.out.println("Setting isDeleted to True");
		this.isDeleted = true;
	}
	
	protected AtharvaCourse() {
		
	}
	
	public AtharvaCourse(String name) {
		this.name=name;
	
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public List<AtharvaReview> getReviews() {
		return reviews;
	}

	public void addReview(AtharvaReview review) {
		this.reviews.add(review);
	}
	public void removeReview(AtharvaReview review) {
		this.reviews.remove(review);
	}

	public List<AtharvaStudent> getStudents() {
		return students;
	}

	public void addStudent(AtharvaStudent student) {
		this.students.add(student);
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "AtharvaCourse [name=" + name + ", reviews=" + reviews + "]";
	}
		

}
