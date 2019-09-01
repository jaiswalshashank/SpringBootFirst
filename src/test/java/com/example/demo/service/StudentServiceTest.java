package com.example.demo.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.entity.Students;
import com.example.demo.services.StudentService;

class StudentServiceTest {
	
	StudentService studentService;

	@BeforeEach
	void setUp() throws Exception {
		studentService=mock(StudentService.class);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddStudent() {
		when(studentService.addStudent(getBean())).thenReturn(getBean());
		//verify(studentService).addStudent(getBean());
		//assertTrue(studentService.addStudent(getBean()) instanceof Students);
	}

	@Test
	void testGetAll() {
		
		List<Students> allList=new ArrayList<>();
		allList.add(getBean());
		when(studentService.getAll()).thenReturn(allList);
		assertEquals(1, studentService.getAll().size() );
		verify(studentService).getAll();
	}

	@Test
	void testGetStudentById() {
		when(studentService.getStudentById(2)).thenReturn(getBean());
		assertEquals("shashank",studentService.getStudentById(2).getsName());
		verify(studentService).getStudentById(2);
	}
	
	public Students getBean() {
		Students std=new Students();
		std.setId(1);
		std.setsName("shashank");
		std.setYear("2");
		std.setIssueDate("10/10/1994");
		return std;
	}

}
