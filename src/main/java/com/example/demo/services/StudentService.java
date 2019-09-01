package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Students;

@Service
public interface StudentService {
	
	public Students addStudent(Students std);
	public List<Students> getAll();
	public Students getStudentById(int sid);

}
