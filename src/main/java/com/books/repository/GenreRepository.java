package com.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.models.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
	List<Genre> findByIdIn(List<Long> b);
}
