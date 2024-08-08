package com.college.DAOLayer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.college.Entities.Course;

public interface CourseDAO extends JpaRepository<Course, Integer>{

	List<Course> findBycName(String name);

	List<Course> findBycType(String type);

	List<Course> findBycDuration(Integer duration);

	List<Course> findBycFee(Double price);
	
	@Query("SELECT c.cId FROM Course c WHERE cName =:name AND cType = :type")
	Integer getBycNameAndcType(String name, String type);

}
