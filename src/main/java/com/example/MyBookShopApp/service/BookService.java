package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksData() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books left join authors a on a.id = books.author_id", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("last_name") + " " + rs.getString("first_name"));
            book.setTitle(rs.getString("title"));
            book.setPrice_old(rs.getString("price_old"));
            book.setPrice(rs.getString("price"));
            return book;
        });
        return new ArrayList<>(books);
    }

    public List<Book> findBookByTitle(String x) {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books left join authors a on a.id = books.author_id where lower(books.title) like '%' || ? || '%'", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("last_name") + " " + rs.getString("first_name"));
            book.setTitle(rs.getString("title"));
            book.setPrice_old(rs.getString("price_old"));
            book.setPrice(rs.getString("price"));
            return book;
        }, x.toLowerCase());
        return new ArrayList<>(books);
    }

    public List<Book> findBookByAuthor(String x) {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books left join authors a on a.id = books.author_id where lower(a.last_name) like '%' || ? || '%'", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("last_name") + " " + rs.getString("first_name"));
            book.setTitle(rs.getString("title"));
            book.setPrice_old(rs.getString("price_old"));
            book.setPrice(rs.getString("price"));
            return book;
        }, x.toLowerCase());
        return new ArrayList<>(books);
    }
}
