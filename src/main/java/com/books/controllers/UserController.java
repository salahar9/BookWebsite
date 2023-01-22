package com.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.models.User;
import com.books.repository.UserRepository;

//import models.User;
//import models.UserRepository;

@RestController
@RequestMapping("api/user")
class UserController {

	private final UserRepository repository;

	@Autowired
	UserController(UserRepository repository) {
		this.repository = repository;
	}

	@PostMapping("insert")
	String insert(@RequestParam("lname") String lname, @RequestParam("fname") String fname,
			@RequestParam("username") String username, @RequestParam("password") String password) {
		User a = new User();
		a.setLname(lname);
		a.setPassword(password);
		a.setUsername(username);
		a.setFname(fname);
		this.repository.save(a);
		return "done";
	}

	@GetMapping("users")
	List<User> all() {
		return this.repository.findAll();
	}

}