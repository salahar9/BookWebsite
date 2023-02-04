package com.books.services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.books.models.Book;
import com.books.repository.BookRepository;
import com.books.repository.UserRepository;

@Service
public class AdminService {
	private final UserRepository UserRepository;
	private final BookRepository BookRepository;
	private final PasswordEncoder encoder;
	org.slf4j.Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	AdminService(UserRepository userrepository, BookRepository bookrepository, PasswordEncoder encoder) {
		this.UserRepository = userrepository;
		this.BookRepository = bookrepository;
		this.encoder = encoder;
	}

	public Boolean addbook(Book book) {
		logger.warn(book.getGenres().toString());
		this.BookRepository.save(book);
		return true;
	}

}
