package com.books.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository repository;

	@Autowired
	UserService(UserRepository repository) {
		this.repository = repository;
	}

}
