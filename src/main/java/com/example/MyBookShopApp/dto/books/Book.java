package com.example.MyBookShopApp.dto.books;

import com.example.MyBookShopApp.dto.Author;
import com.example.MyBookShopApp.dto.Photo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "books")
public class Book implements Comparable<Book>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    //private List<Author> authors = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private Rating rating;

    @JoinColumn(name = "title")
    private String title;

    @JoinColumn(name = "price_old")
    private String price_old;

    @JoinColumn(name = "discount")
    private int discount;

    @JoinColumn(name = "price")
    private String price;

    @JoinColumn(name = "currency_code")
    private String currencyCode;

    @JoinColumn(name = "pub_date")
    private Date pub_date;

    @JoinColumn(name = "slug")
    private String slug;

    @JoinColumn(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Photo photo;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(title, book.title)
                && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.title);
    }

}
