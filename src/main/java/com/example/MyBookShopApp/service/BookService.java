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
        List<Book> books = jdbcTemplate.query("SELECT * FROM books left join authors a on a.id = books.author", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("lastName") + " " + rs.getString("firstName"));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("priceOld"));
            book.setPrice(rs.getString("price"));
            return book;
        });
        return new ArrayList<>(books);
    }

    public List<Book> findBookByTitle(String x) {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books left join authors a on a.id = books.author where lower(books.title) like '%' || ? || '%'", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("lastName") + " " + rs.getString("firstName"));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("priceOld"));
            book.setPrice(rs.getString("price"));
            return book;
        }, x.toLowerCase());
        return new ArrayList<>(books);
    }

    public List<Book> findBookByAuthor(String x) {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books left join authors a on a.id = books.author where lower(a.lastName) like '%' || ? || '%'", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("lastName") + " " + rs.getString("firstName"));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("priceOld"));
            book.setPrice(rs.getString("price"));
            return book;
        }, x.toLowerCase());
        return new ArrayList<>(books);
    }
}
