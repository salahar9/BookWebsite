package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String name);

}
