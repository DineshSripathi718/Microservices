package com.college.Entity;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer sId;
	private String sName;
	private String sEmail;
	private String sPassword;
	private Long sPhone;
	
	@ElementCollection
	private List<Integer> course = new LinkedList();

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	public Long getsPhone() {
		return sPhone;
	}

	public void setsPhone(Long sPhone) {
		this.sPhone = sPhone;
	}

	public List<Integer> getCourse() {
		return course;
	}

	public void setCourse(List<Integer> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sEmail=" + sEmail + ", sPassword=" + sPassword
				+ ", sPhone=" + sPhone + ", course=" + course + "]";
	}
	
	
}
