package com.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.models.BookClub;
import com.books.models.BookClubDiscussion;
import com.books.models.User;

@Repository
public interface BookClubDiscussionRepository extends JpaRepository<BookClubDiscussion, Long> {

	List<BookClubDiscussion> findByUserAndBookclub(User user, BookClub bookclub);

	// User findByUsername(String name);

}
