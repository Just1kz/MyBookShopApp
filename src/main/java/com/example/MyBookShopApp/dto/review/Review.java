package com.example.MyBookShopApp.dto.review;

import com.example.MyBookShopApp.dto.books.Book;
import com.example.MyBookShopApp.dto.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "books_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    @JoinColumn(name = "time")
    private Date date;

    @JoinColumn(name = "text")
    private String text;
}
