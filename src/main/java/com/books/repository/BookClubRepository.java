package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.models.BookClub;

@Repository
public interface BookClubRepository extends JpaRepository<BookClub, Long> {

	// User findByUsername(String name);

}
