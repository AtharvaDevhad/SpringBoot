package com.jpahibernate.JpaHibernate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<AtharvaCourse, Long>{
 List<AtharvaCourse>findByName(String name);
 List<AtharvaCourse>findByNameAndId(String name ,Long id);
 List<AtharvaCourse>countByName(String name);
 List<AtharvaCourse>findByNameOrderByIdDesc(String name);
 List<AtharvaCourse>deleteByName(String name);
 @Query("select c from AtharvaCourse c where name like '%100 Steps'")
 List<AtharvaCourse>coursesWith100StepsInName();
 
 @Query(value="select * from AtharvaCourse c where name like '%100 Steps'",
		 nativeQuery=true)
 List<AtharvaCourse>coursesWith100StepsInNameUsingNativeQuery();
 
 @Query(name="query_get_100_step_courses")
 List<AtharvaCourse>coursesWith100StepsInNameUsingNamedQuery();
 
 
 }
 
 

