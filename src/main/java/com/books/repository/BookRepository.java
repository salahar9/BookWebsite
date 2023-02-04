package com.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	// User findByUsername(String name);
	List<Book> findByGenres_idIn(List<Long> id);

}
