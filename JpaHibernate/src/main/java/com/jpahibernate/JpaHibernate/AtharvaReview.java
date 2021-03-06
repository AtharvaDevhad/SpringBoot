 package com.jpahibernate.JpaHibernate;

//import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
*/
@Entity



public class AtharvaReview {
	@Id
	@GeneratedValue
	
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private ReviewRating rating;
	
	private String description;
	
	
	@ManyToOne
	private AtharvaCourse course;
	
	
	protected AtharvaReview() {
		
	}
	
	public AtharvaReview(ReviewRating rating,String description) {
		this.rating = rating;
		this.description=description;
	
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description =description;
	}
	
	
	
	public ReviewRating getRating() {
		return rating;
	}

	public void setRating(ReviewRating rating) {
		this.rating = rating;
	}

	
	
	public AtharvaCourse getCourse() {
		return course;
	}

	public void setCourse(AtharvaCourse course) {
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "AtharvaReview [rating=" + rating + ", description=" + description + "]";
	}
		

}
