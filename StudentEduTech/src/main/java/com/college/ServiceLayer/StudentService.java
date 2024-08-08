package com.college.ServiceLayer;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.DAOLayer.StudentDAO;
import com.college.Entity.Student;
import com.college.FeignLayer.CourseInterface;
import com.college.WrapperClasses.Course;
import com.college.WrapperClasses.StudentRequest;
import com.college.WrapperClasses.StudentWrapper;

@Service
public class StudentService {
	
	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	StudentWrapper studentWrapper;
	
	@Autowired
	CourseInterface courseInterface;
	
	public ResponseEntity<List<StudentWrapper>> getAllStudents() {
		try {
			Integer count = 0;
			List<Student> student = studentDAO.findAll();
			List<StudentWrapper> studentsWrapper = new LinkedList();
			
			for(Student s : student) {
				studentWrapper = new StudentWrapper();
				studentWrapper.setsId(s.getsId());
				studentWrapper.setsName(s.getsName());
				studentWrapper.setsEmail(s.getsEmail());
				studentWrapper.setsPhone(s.getsPhone());
			
				for(Integer cId : s.getCourse()) {
					Course course = courseInterface.getCourseBycId(cId);
		
					studentWrapper.setcName(course.getcName());
					studentWrapper.setcType(course.getcType());
					studentWrapper.setcFee(course.getcFee());
					studentWrapper.setcDuration(course.getcDuration());
				}
				
				System.out.println("---------------------------------------------");
				System.err.println(" Iteration "+ ++count);
				System.out.println(studentWrapper);
				studentsWrapper.add(studentWrapper);
				System.err.println(studentsWrapper);
				System.out.println("---------------------------------------------");
			}
 			return new ResponseEntity<>(studentsWrapper, HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<StudentWrapper> getStudentById(Integer id) {

		try {
			Student student = studentDAO.findById(id).orElse(null);
			
			studentWrapper.setsName(student.getsName());
			studentWrapper.setsId(student.getsId());
			studentWrapper.setsEmail(student.getsEmail());
			studentWrapper.setsPhone(student.getsPhone());
//			studentWrapper.setcName(student.getCourse());
			
			return new ResponseEntity<>(studentWrapper, HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<StudentWrapper>> getStudentByName(String name) {
		try {
			List<Student> students = studentDAO.findBysName(name);
			List<StudentWrapper> studentsWrapper = new LinkedList();
			for(Student student : students) {
				studentWrapper.setsName(student.getsName());
				studentWrapper.setsId(student.getsId());
				studentWrapper.setsEmail(student.getsEmail());
				studentWrapper.setsPhone(student.getsPhone());
//				studentWrapper.setcName(student.getCourse());
				
				studentsWrapper.add(studentWrapper);
			}
			return new ResponseEntity<>(studentsWrapper, HttpStatus.ACCEPTED);
		}catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<StudentWrapper> getStudentByEmail(String email) {
		try {
			Student student = studentDAO.findBysEmail(email);
			
			studentWrapper.setsName(student.getsName());
			studentWrapper.setsId(student.getsId());
			studentWrapper.setsEmail(student.getsEmail());
			studentWrapper.setsPhone(student.getsPhone());
//			studentWrapper.setcName(student.getCourse());
			
			return new ResponseEntity<>(studentWrapper, HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Student> createStudent(StudentRequest student) {
		try {
			Student s = new Student();
			
			
			s.setsName(student.getStudent().getsName());
			s.setsEmail(student.getStudent().getsEmail());
			s.setsPhone(student.getStudent().getsPhone());
			s.setsPassword(student.getStudent().getsPassword());
			System.err.println("Before the courseInterface");
			Integer course = courseInterface.getCourseBycNameAndcType(student.getcName(), student.getcType());
			System.err.println("After course interface");
			s.getCourse().add(course);
			System.err.println(s);
			
			studentDAO.save(s);
			
			return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
