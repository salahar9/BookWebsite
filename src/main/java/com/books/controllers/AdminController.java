package com.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.books.DTOs.BookInsert;
import com.books.DTOs.JsonResponse;
import com.books.services.AdminService;

//import models.User;
//import models.UserRepository;

@RestController
@RequestMapping("api/admin")
class AdminController {

	private final AdminService service;

	@Autowired
	AdminController(AdminService service) {
		this.service = service;

	}

	@PostMapping("addbook")
	@ResponseBody
	JsonResponse addbook(@RequestBody BookInsert book) {
		Boolean resp = service.addbook(book);
		JsonResponse res = new JsonResponse();
		res.setStatus(resp);
		return res;
	}

}