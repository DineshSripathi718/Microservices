package com.college.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.DAOLayer.CourseDAO;
import com.college.Entities.Course;

@Service
public class CourseService {
	
	@Autowired
	CourseDAO courseDAO;
	
	public ResponseEntity<Course> saveCourse(Course course){
		try {
			courseDAO.save(course);
			return new ResponseEntity<>(course, HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Course>> getAllCourses() {
		try {
			List<Course> course = courseDAO.findAll();
			return new ResponseEntity<>(course, HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Course> getCourseById(Integer id) {
		try {
			Course course = courseDAO.findById(id).orElse(null);
			return new ResponseEntity<>(course, HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Course>> getCourseByName(String name) {
		try {
			List<Course> course = courseDAO.findBycName(name);
			return new ResponseEntity<>(course, HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Course>> getCourseByType(String type) {
		try {
			List<Course> course = courseDAO.findBycType(type);
			return new ResponseEntity<>(course, HttpStatus.ACCEPTED);
			
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Course>> getCourseByDuration(Integer duration) {
		try {
			List<Course> course = courseDAO.findBycDuration(duration);
			return new ResponseEntity<>(course, HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Course>> getCourseByPrice(Double price) {
		try {
			List<Course> course = courseDAO.findBycFee(price);
			return new ResponseEntity<>(course, HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Integer> getCourseByNameAndType(String name, String type) {
		try {
			Integer course = courseDAO.getBycNameAndcType(name, type);
			return new ResponseEntity<>(course, HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
