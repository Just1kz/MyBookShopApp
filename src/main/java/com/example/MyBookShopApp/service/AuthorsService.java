package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.dto.Author;
import com.example.MyBookShopApp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorsService {
    private final JdbcTemplate jdbcTemplate;
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorsService(JdbcTemplate jdbcTemplate, AuthorRepository authorRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.authorRepository = authorRepository;
    }

    public Map<String, List<Author>> getAuthorsMap() {
        List<Author> authors = jdbcTemplate.query("select * from authors", (ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            return author;
        });
        return authors.stream()
                .sorted(Comparator.comparing(Author::getLastName))
                .collect(Collectors.groupingBy(
                (Author a) -> a.getLastName().substring(0, 1)));
    }

    public Map<String, List<Author>> getAuthorsMapJPA() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .sorted(Comparator.comparing(Author::getLastName))
                .collect(Collectors.groupingBy(
                        (Author a) -> a.getLastName().substring(0, 1)));
    }
}
