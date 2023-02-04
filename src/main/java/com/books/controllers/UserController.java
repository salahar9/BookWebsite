package com.books.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.books.models.Book;
import com.books.models.BookClub;
import com.books.models.BookClubDiscussion;
import com.books.models.BookClubUsers;
import com.books.models.User;
import com.books.models.WishList;
import com.books.services.JsonResponse;
import com.books.services.Test;
import com.books.services.UserService;

//import models.User;
//import models.UserRepository;

@RestController
@RequestMapping("api/user")
class UserController {

	private final UserService service;

	@Autowired
	UserController(UserService service) {
		this.service = service;

	}

	@PostMapping("register")
	JsonResponse insert(@RequestParam("lname") String lname, @RequestParam("fname") String fname,
			@RequestParam("username") String username, @RequestParam("password") String password) {

		Boolean resp = service.insert(lname, fname, username, password);
		JsonResponse res = new JsonResponse();

		res.setStatus(resp);
		return res;
	}

	@PostMapping("addbookclub")
	@ResponseBody
	JsonResponse addbookclub(Principal principal, @RequestBody BookClub bookclub) {
		Boolean resp = service.addbookclub(principal, bookclub);
		JsonResponse res = new JsonResponse();
		res.setStatus(resp);
		return res;
	}

	@PostMapping("invitebookclub")
	@ResponseBody
	JsonResponse invitebookclub(Principal principal, @RequestBody BookClub bookclub) {
		Boolean resp = service.invitebookclub(principal, bookclub);
		JsonResponse res = new JsonResponse();
		res.setStatus(resp);
		return res;
	}

	@GetMapping("users")
	List<User> all() {
		return this.service.list();
	}

	@GetMapping("bookclubs")
	@ResponseBody
	public Set<BookClubUsers> getBookClubs(Principal principal) {
		return this.service.getBookClubs(principal);
	}

	@PostMapping("bookclub/messages")
	@ResponseBody
	public List<BookClubDiscussion> messagebookclub(Principal principal, @RequestBody BookClubDiscussion d) {
		return this.service.messagebookclub(principal, d);
	}

	@PostMapping("bookclub/discuss")
	@ResponseBody
	public JsonResponse sendbookclub(Principal principal, @RequestBody BookClubDiscussion bookclub) {
		Boolean resp = service.sendmessagebookclub(principal, bookclub);
		JsonResponse res = new JsonResponse();
		res.setStatus(resp);
		return res;
	}

	@PostMapping("wishlist/add")
	@ResponseBody
	public JsonResponse addtowishlist(Principal principal, @RequestBody WishList wishlist) {
		Boolean resp = service.addTowishlist(principal, wishlist);
		JsonResponse res = new JsonResponse();
		res.setStatus(resp);
		return res;
	}

	@GetMapping("wishlist")
	@ResponseBody
	public Set<WishList> list_wishlist(Principal principal) {
		return this.service.list_wishlist(principal);
	}

	@GetMapping("user")
	@ResponseBody
	public JsonResponse getuser(Principal principal) {
		return this.service.user(principal);
	}

	@PostMapping("getbooks")
	@ResponseBody
	public JsonResponse books(Principal principal) {
		return this.service.books(principal);
	}

	@PostMapping("bookdetail")
	@ResponseBody
	public JsonResponse bookdetail(Principal principal, @RequestBody Book book) {
		return this.service.bookdetail(principal, book);
	}

	@PostMapping("samebooks")
	@ResponseBody
	public JsonResponse booksamegenres(Principal principal, @RequestBody Test book) {
		return this.service.booksamegenres(principal, book);

	}

}