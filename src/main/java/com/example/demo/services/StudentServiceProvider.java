package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.StudentRepo;
import com.example.demo.entity.Students;

@Component
public class StudentServiceProvider implements StudentService {

	@Autowired
	private StudentRepo stdDao;
	
	@Override
	public Students addStudent(Students std) {
		Students st=stdDao.save(std);
		return st;
	}

	@Override
	public List<Students> getAll() {
		List<Students> allStd=new ArrayList<>();
		stdDao.findAll().forEach(s->allStd.add(s));
		return allStd;
	}

	@Override
	public Students getStudentById(int sid) {
		return stdDao.findById(sid).orElse(new Students());
	}



}
