package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.dto.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
