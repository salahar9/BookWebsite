package com.books.services;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.books.DTOs.BookInsert;
import com.books.models.Book;
import com.books.models.Genre;
import com.books.repository.BookRepository;
import com.books.repository.GenreRepository;
import com.books.repository.UserRepository;

@Service
public class AdminService {
	private final UserRepository UserRepository;
	private final GenreRepository GenreRepository;

	private final BookRepository BookRepository;
	private final PasswordEncoder encoder;
	org.slf4j.Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	AdminService(UserRepository userrepository, GenreRepository GenreRepository, BookRepository bookrepository,
			PasswordEncoder encoder) {
		this.UserRepository = userrepository;
		this.BookRepository = bookrepository;
		this.GenreRepository = GenreRepository;
		this.encoder = encoder;
	}

	public Boolean addbook(BookInsert book) {
		// List<Long> b = book.getIdGenres();
		List<Genre> b = GenreRepository.findByIdIn(book.getIdGenres());
		logger.warn(b.toString());
		Book real_book = new Book();
		real_book.setNomAuteur(book.getNomAuteur());
		real_book.setMaisonEdition(book.getMaisonEdition());
		real_book.setNomLivre(book.getNomLivre());
		real_book.setEdition(book.getEdition());
		real_book.setPathEpub(book.getPathEpub());
		real_book.setPathPdf(book.getPathPdf());
		Set<Genre> g = real_book.getGenres();
		for (Iterator<Genre> iter = b.iterator(); iter.hasNext();) {

			Genre element = iter.next();
			g.add(element);
			element.getBooks().add(real_book);

		}

		this.BookRepository.save(real_book);
		return true;
	}

}
