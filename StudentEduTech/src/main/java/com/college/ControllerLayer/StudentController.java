package com.college.ControllerLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.Entity.Student;
import com.college.ServiceLayer.StudentService;
import com.college.WrapperClasses.StudentRequest;
import com.college.WrapperClasses.StudentWrapper;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/getStudent/all")
	public ResponseEntity<List<StudentWrapper>> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getStudent/id/{id}")
	public ResponseEntity<StudentWrapper> getStudentById(@PathVariable("id")Integer id){
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/getStudent/studentname/{name}")
	public ResponseEntity<List<StudentWrapper>> getStudentByName(@PathVariable("name")String name){
        return studentService.getStudentByName(name);
    }
	
	@GetMapping("/getStudent/studentemail/{email}")
	public ResponseEntity<StudentWrapper> getStudentByEmail(@PathVariable("email")String email){
        return studentService.getStudentByEmail(email);
    }
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> createStudent(@RequestBody StudentRequest student){
		return studentService.createStudent(student);
    }
}
