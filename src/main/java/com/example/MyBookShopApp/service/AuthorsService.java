package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.dto.Author;
import com.example.MyBookShopApp.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorsService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> getAuthorData(String category) {
        List<Author> authors = jdbcTemplate.query("select * from authors where category = ?", (ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setName(rs.getString("authorName"));
            author.setCategory(rs.getString("category"));
            return author;
        }, category);
        return new ArrayList<>(authors);
    }
}
