package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controllers.StudentController;
import com.example.demo.entity.Students;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
class StudentControllerTest {

	@InjectMocks
	private StudentController studentController;

	private MockMvc mockMvc;

	private ObjectMapper maper = new ObjectMapper();

	@BeforeEach
	void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAll() throws Exception {
		MvcResult res = mockMvc
				.perform(MockMvcRequestBuilders.get("/student").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String result = res.getResponse().getContentAsString();
		List<Students> allList=new ArrayList<>();
		Students std = new Students();
		std.setId(1);
		std.setsName("shashank");
		std.setYear("2");
		std.setIssueDate("10/10/1994");
		allList.add(std);
		
		assertTrue(maper.writeValueAsString(allList).equals(result));
	}

	@Test
	void testAddStudent() throws Exception {
		MvcResult res = mockMvc.perform(MockMvcRequestBuilders.post("/student/addStudent").content(getBean())
				.content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String result = res.getResponse().getContentAsString();
		assertTrue(getBean().equals(result));
	}

	/*
	 * @Test void testGetStudentDetails() throws Exception {
	 * fail("Not yet implemented"); }
	 */

	public String getBean() throws JsonProcessingException {
		Students std = new Students();
		std.setId(1);
		std.setsName("shashank");
		std.setYear("2");
		std.setIssueDate("10/10/1994");
		return maper.writeValueAsString(std);
	}

}
