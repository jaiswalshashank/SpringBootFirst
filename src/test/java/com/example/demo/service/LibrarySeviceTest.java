package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.services.LibraryService;
import com.example.demo.entity.Library;

class LibrarySeviceTest {
	
	@Mock private LibraryService librarySevice;

	@BeforeEach
	void setUp() throws Exception {
		//librarySevice=mock(LibraryService.class);
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAll() {
		List<Library> allList=new ArrayList<>();
		allList.add(getLibrary());
		when(librarySevice.getAll()).thenReturn(allList);
		assertEquals(1, librarySevice.getAll().size() );
		verify(librarySevice).getAll();
	}

	@Test
	void testGetBookById() {
		when(librarySevice.getBookById(1)).thenReturn(getLibrary());
		assertEquals("maths",librarySevice.getBookById(1).getBookName());
		verify(librarySevice).getBookById(1);
	}

	@Test
	void testAddBook() {
		//fail("Not yet implemented");
	}

	@Test
	void testIssueBooksToStudent() {
		//fail("Not yet implemented");
	}
	
	
	public Library getLibrary() {
		Library lib=new Library();
		lib.setId(1);
		lib.setBookName("maths");
		lib.setAuthor("hk das");
		lib.setQuantity(200);
		return lib;
	}

}
