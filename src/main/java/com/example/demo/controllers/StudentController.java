package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Students;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("")
	public List<Students> getAll(){
		
		return studentService.getAll();
	}
	
	@PostMapping("/addStudent")
	public void addStudent(@RequestBody Students std) {
		studentService.addStudent(std);
	}
	
	@GetMapping("/{id}")
	public Students getStudentDetails(@PathVariable("id") int sid) {
		
		return studentService.getStudentById(sid);
	}

}
