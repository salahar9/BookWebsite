package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.models.Download;

@Repository
public interface DownloadRepository extends JpaRepository<Download, Long> {
}
