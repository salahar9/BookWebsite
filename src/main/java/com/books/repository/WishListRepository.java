package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.models.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {

	// User findByUsername(String name);

}
