package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Library;

@Service
public interface LibraryService {
	
	public List<Library> getAll();
	public Library getBookById(int bookId);
	public void addBook(Library lib);
	public void issueBooksToStudent(int studentId);

}
