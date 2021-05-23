package com.example.MyBookShopApp.dto;

import com.example.MyBookShopApp.dto.books.Book;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "title")
    private String title;

    @OneToMany(mappedBy = "photo")
    private List<Book> bookList = new ArrayList<>();

    @OneToMany(mappedBy = "photo")
    private List<Author> authorList = new ArrayList<>();

}
