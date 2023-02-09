package com.books.services;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.books.DTOs.JsonResponse;
import com.books.DTOs.ReviewInsert;
import com.books.DTOs.Test;
import com.books.models.Book;
import com.books.models.BookClub;
import com.books.models.BookClubDiscussion;
import com.books.models.BookClubUsers;
import com.books.models.Download;
import com.books.models.Review;
import com.books.models.User;
import com.books.models.WishList;
import com.books.repository.BookClubDiscussionRepository;
import com.books.repository.BookClubRepository;
import com.books.repository.BookClubUserRepository;
import com.books.repository.BookRepository;
import com.books.repository.DownloadRepository;
import com.books.repository.ReviewRepository;
import com.books.repository.UserRepository;
import com.books.repository.WishListRepository;

@Service
public class UserService {
	private final BookClubUserRepository BookClubUserRepository;
	private final BookClubDiscussionRepository BookClubDiscussionRepository;
	private final UserRepository repository;
	private final PasswordEncoder encoder;
	private final BookRepository BookRepository;
	private final BookClubRepository BookClubRepository;
	private final WishListRepository WishListRepository;
	private final DownloadRepository DownloadRepository;
	private final ReviewRepository ReviewRepository;
	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserService(ReviewRepository ReviewRepository, UserRepository repository, BookClubRepository bookclubrepository,
			BookRepository bookrepository, DownloadRepository DownloadRepository,
			BookClubDiscussionRepository BookClubDiscussionRepository, PasswordEncoder encoder,
			WishListRepository WishListRepository, BookClubUserRepository BookClubUserRepository) {
		this.BookClubUserRepository = BookClubUserRepository;
		this.repository = repository;
		this.BookRepository = bookrepository;
		this.BookClubRepository = bookclubrepository;
		this.BookClubDiscussionRepository = BookClubDiscussionRepository;
		this.DownloadRepository = DownloadRepository;
		this.WishListRepository = WishListRepository;
		this.ReviewRepository = ReviewRepository;
		this.encoder = encoder;
	}

	public boolean insert(String lname, String fname, String username, String password) {

		User a = new User();
		a.setLname(lname);

		a.setPassword(encoder.encode(password));
		a.setUsername(username);
		a.setFname(fname);
		this.repository.save(a);
		return true;
	}

	public List<User> list() {
		return this.repository.findAll();
	}

	public Boolean addbookclub(Principal principal, BookClub bookclub) {
//		logger.warn(Long.toString(bookclub.getIdBookClub()));
//		logger.warn(bookclub.getNomBookClub());
		User user = repository.findByUsername((principal).getName());
		BookClubUsers s = new BookClubUsers(user, bookclub);
		Set<BookClubUsers> d = bookclub.getBookclubs();
		d.add(s);
		bookclub.setBookclubs(d);
		this.BookClubRepository.save(bookclub);
		// logger.warn(bookclub.getBookclubs().toString());
		return true;
	}

	public Boolean invitebookclub(Principal principal, BookClub bookclub) {

		// logger.warn(Long.toString(bookclub.getIdBookClub()));
		User user = repository.findByUsername((principal).getName());
		BookClub bookclub1 = BookClubRepository.findById(bookclub.getIdBookClub()).get();
		BookClubUsers s = new BookClubUsers(user, bookclub1);
		// Set<BookClubUsers> d = bookclub1.getBookclubs();
		// d.add(s);

		this.BookClubUserRepository.save(s);
		Set<BookClubUsers> d = bookclub1.getBookclubs();
		logger.warn(d.toString());

		return true;
	}

	public Set<BookClubUsers> getBookClubs(Principal principal) {

		// logger.warn(Long.toString(bookclub.getIdBookClub()));
		User user = repository.findByUsername((principal).getName());

		return user.getBookclubs();

	}

	public Boolean sendmessagebookclub(Principal principal, BookClubDiscussion d) {
		User user = repository.findByUsername((principal).getName());
		BookClub bookclub = BookClubRepository.findById(d.getBookclub().getIdBookClub()).get();

		// @Query("select * from book_club_users where id_user= and id_book_club= ")
		// BookClubUsers bookclub1 = BookClubUserRepository.bookclubuser(user.getId(),
		// d.getBookclub().getIdBookClub());
		BookClubUsers bookclub1 = BookClubUserRepository.findByUserAndBookclub(user, bookclub);
		if (bookclub1 == null) {
			return false;
		}
		BookClubDiscussion a = new BookClubDiscussion(user, bookclub, d.getMessage());
		BookClubDiscussionRepository.save(a);
		return true;
	}

	public List<BookClubDiscussion> messagebookclub(Principal principal, BookClubDiscussion d) {
		User user = repository.findByUsername((principal).getName());
		BookClub bookclub = BookClubRepository.findById(d.getBookclub().getIdBookClub()).get();
		List<BookClubDiscussion> bookclub1 = BookClubDiscussionRepository.findByUserAndBookclub(user, bookclub);
		return bookclub1;

	}

	public Boolean addTowishlist(Principal principal, WishList wishlist) {
		User user = repository.findByUsername((principal).getName());
		Book b = BookRepository.findById(wishlist.getBook().getId()).get();
		logger.warn(b.toString());
		WishList w = new WishList(user, b);
		WishListRepository.save(w);
		return true;
	}

	public Set<WishList> list_wishlist(Principal principal) {
		// TODO Auto-generated method stub
		User user = repository.findByUsername((principal).getName());

		return user.getWishlist();

	}

	public Boolean Download(Principal principal, WishList wishlist) {
		User user = repository.findByUsername((principal).getName());
		Book b = BookRepository.findById(wishlist.getBook().getId()).get();
		logger.warn(b.toString());
		Download w = new Download(user, b);
		DownloadRepository.save(w);
		return true;
	}

	public Set<Download> list_downloads(Principal principal) {
		// TODO Auto-generated method stub
		User user = repository.findByUsername((principal).getName());

		return user.getDownloads();

	}

	public JsonResponse user(Principal principal) {
		User user = repository.findByUsername((principal).getName());
		JsonResponse j = new JsonResponse();
		j.setStatus(true);
		j.setEmail(user.getUsername());
		j.setFname(user.getFname());
		j.setLname(user.getLname());
		j.setRole(user.getRole());
		logger.warn("hahowa jaa");
		return j;
	}

	public JsonResponse books(Principal principal) {
		List<Book> b = BookRepository.findAll();
		JsonResponse j = new JsonResponse();
		j.setStatus(true);
		j.setBooks(b);

		return j;
	}

	public JsonResponse bookdetail(Principal principal, Book book) {
		Book b = BookRepository.findById(book.getId()).get();
		JsonResponse j = new JsonResponse();
		j.setStatus(true);
		j.setBook(b);

		return j;
	}

	public JsonResponse booksamegenres(Principal principal, Test book) {
		List<Book> b = BookRepository.findByGenres_idIn(book.getId());
		JsonResponse j = new JsonResponse();
		j.setStatus(true);
		j.setBooks(b);

		return j;
	}

	public JsonResponse addReview(Principal principal, ReviewInsert r) {
		logger.warn(r.getBook().toString());
		Book b = BookRepository.findById(r.getBook()).get();
		User u = repository.findByUsername(((principal).getName()));
		Review rev = new Review();
		rev.setBook(b);
		rev.setUser(u);
		rev.setCommentaire(r.getCommentaire());
		rev.setRating(r.getRating());
		ReviewRepository.save(rev);
		JsonResponse j = new JsonResponse();
		j.setStatus(true);
		return j;
	}

}
