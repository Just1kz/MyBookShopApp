package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.dto.Author;
import com.example.MyBookShopApp.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorsService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, List<Author>> getAuthorsMap() {
        List<Author> authors = jdbcTemplate.query("select * from authors", (ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirst_name(rs.getString("first_name"));
            author.setLast_name(rs.getString("last_name"));
            return author;
        });
        return authors.stream()
                .sorted(Comparator.comparing(Author::getLast_name))
                .collect(Collectors.groupingBy(
                (Author a) -> a.getLast_name().substring(0, 1)));
    }
}
