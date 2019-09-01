package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Library;

public interface LibraryRepo extends CrudRepository<Library, Integer> {
	
	

}
