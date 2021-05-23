package com.example.MyBookShopApp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    private String title;
    private String price_old;
    private String price;
//    private Date date;
//    private String tag;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(author, book.author)
                && Objects.equals(title, book.title)
                && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, price);
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", price_old='" + price_old + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
