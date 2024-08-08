package com.college.WrapperClasses;

import org.springframework.stereotype.Component;

import com.college.Entity.Student;


public class StudentRequest {
	private Student student;
	private String cName;
	private String cType;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcType() {
		return cType;
	}
	public void setcType(String cType) {
		this.cType = cType;
	}
	@Override
	public String toString() {
		return "StudentRequest [student=" + student + ", cName=" + cName + ", cType=" + cType + "]";
	}
	
	
}
