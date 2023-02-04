package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.books.models.BookClub;
import com.books.models.BookClubUsers;
import com.books.models.User;

@Repository
public interface BookClubUserRepository extends JpaRepository<BookClubUsers, Long> {

	BookClubUsers findByUserAndBookclub(User user, BookClub bookclub);

	@Query(value = "SELECT u  from BookClubUsers u where u.user=?1 and u.bookclub= ?2", nativeQuery = false)
	BookClubUsers bookclubuser(Long id, Long bookclubid);

	// User findByUsername(String name);

}
