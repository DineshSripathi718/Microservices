package com.college.DAOLayer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.Entity.Student;

public interface StudentDAO extends JpaRepository<Student, Integer>{

	List<Student> findBysName(String name);

	Student findBysEmail(String email);

}
