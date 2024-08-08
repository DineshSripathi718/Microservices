package com.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.Entities.Course;
import com.college.services.CourseService;

/*
 * This controller will handle all the URLs or the requests that was sent by the user.
 * You can find the below requests and response will generate
 * */
@RestController
@RequestMapping(path="course")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping(path="saveCourse")
	public ResponseEntity<Course> saveStudent(@RequestBody Course course){
		return courseService.saveCourse(course);
	}
	
	@GetMapping(path="getCourse/all")
	public ResponseEntity<List<Course>> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@GetMapping(path="getCourse/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer id){
        return courseService.getCourseById(id);
    }
	
	@GetMapping(path="getCourse/{name}")
	public ResponseEntity<List<Course>> getCourseByName(@PathVariable("name") String name){
        return courseService.getCourseByName(name);
    }
	
	@GetMapping(path="getCourse/type/{type}")
	public ResponseEntity<List<Course>> getCourseByType(@PathVariable("type") String type){
        return courseService.getCourseByType(type);
    }
	
	@GetMapping(path="getCourse/duration/{duration}")
	public ResponseEntity<List<Course>> getCourseByDuration(@PathVariable("duration") Integer duration){
        return courseService.getCourseByDuration(duration);
    }
	
	@GetMapping(path="getCourse/price/{price}")
    public ResponseEntity<List<Course>> getCourseByPrice(@PathVariable("price") Double price){
        return courseService.getCourseByPrice(price);
    }
	
	//methods used by the student services -- starts
	
	@PostMapping(path="getCourse/type/{cType}/name/{cName}")
	public ResponseEntity<Integer> getCourseByCriteria(@PathVariable("cName") String name, @PathVariable("cType") String type){
		System.err.println(name+" "+type);
		return courseService.getCourseByNameAndType(name, type);
	}
	
	@GetMapping(path="getCourse/id/{id}")
    public ResponseEntity<Course> getCourseBycId(@PathVariable("id") Integer id){
        return courseService.getCourseById(id);
    }
	
	//methods used by the student services -- ends
}
