package com.example.MyBookShopApp.dto.books;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "rating_books")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "rating")
    private List<Book> bookList = new ArrayList<>();

    @JoinColumn(name = "paid_count")
    private int paidCount;

    @JoinColumn(name = "cart_count")
    private int cartCount;

    @JoinColumn(name = "postponed_count")
    private int postponedCount;

    @JoinColumn(name = "result")
    private double result;
}
