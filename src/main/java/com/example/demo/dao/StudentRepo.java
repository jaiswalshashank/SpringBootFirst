package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Students;

public interface StudentRepo extends CrudRepository<Students, Integer>{
	
	

}
