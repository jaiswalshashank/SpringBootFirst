package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Library;
import com.example.demo.services.LibraryService;


@RestController
@RequestMapping("library")
public class LibraryController {
	
	@Autowired
	private LibraryService libService;
	
	@GetMapping("")
	public List<Library> getAllbooks() {
		return libService.getAll();
	}
	
	@PostMapping("/addBook")
	public void addbooks(@RequestBody Library lib) {
		libService.addBook(lib);
	}
	
	@GetMapping("{id}")
	public Library getBookDetails(@PathVariable("id") int id) {
		
		return libService.getBookById(id);
	}
	
	/*
	 * @PostMapping("/issueBook/{id}") public void issueBook(@PathVariable("id") int
	 * bookId,@RequestParam int studentId) {
	 * //libService.issueBooksToStudent(studentId); }
	 */

}
