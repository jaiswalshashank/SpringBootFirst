package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.LibraryRepo;
import com.example.demo.entity.Library;

@Component
public class LibrarySeviceProvider implements LibraryService{
	
	@Autowired
	private LibraryRepo libDao;

	@Override
	public List<Library> getAll() {
		List<Library> allBooks=new ArrayList<>();
		libDao.findAll().forEach(l->allBooks.add(l));
		return allBooks;
	}

	@Override
	public Library getBookById(int bookId) {
		// TODO Auto-generated method stub
		return libDao.findById(bookId).orElse(new Library());
	}

	@Override
	public void addBook(Library lib) {
		// TODO Auto-generated method stub
		libDao.save(lib);
		
	}

	@Override
	public void issueBooksToStudent(int studentId) {
		// TODO Auto-generated method stub
		
	}



}
