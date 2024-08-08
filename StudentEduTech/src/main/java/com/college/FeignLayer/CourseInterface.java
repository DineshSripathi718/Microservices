package com.college.FeignLayer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.college.WrapperClasses.Course;

@FeignClient("COURSEEDUTECH")
public interface CourseInterface {
	@PostMapping("course/getCourse/type/{cType}/name/{cName}")
	Integer getCourseBycNameAndcType(@PathVariable("cName") String cName, @PathVariable("cType") String cType);
	
	@GetMapping("course/getCourse/id/{id}")
	Course getCourseBycId(@PathVariable("id")Integer cId);
}
