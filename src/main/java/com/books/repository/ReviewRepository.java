package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
